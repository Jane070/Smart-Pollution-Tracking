package ds.alertservice;

import io.grpc.*;
import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * ClassName: AlertService
 * Description:
 *
 * @Author: Jiaxin Zhang
 * @Version: 1.8
 */
public class AlertService extends AlertServiceGrpc.AlertServiceImplBase{

        private Random random = new Random();
        private Map<String, String> alertMessages = new HashMap<>();

    public static void main(String[] args) {

        AlertService alertService = new AlertService();
        Properties prop = alertService.getProperties();
        alertService.registerService(prop);
        int port = Integer.valueOf( prop.getProperty("service_port") );// #.50053;

        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(alertService)
                    .build()
                    .start();
            System.out.println("Math Server started, listening on " + port);

            server.awaitTermination();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    private Properties getProperties() {

        Properties prop = null;
        try (InputStream input = new FileInputStream("src/main/resources/alert_service.properties")) {
            prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            System.out.println("Math Service properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
            System.out.println("\t service_port: " +prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    private  void registerService(Properties prop) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
            String service_name = prop.getProperty("service_name")  ;// "example";
            // int service_port = 1234;
            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50053;


            String service_description_properties = prop.getProperty("service_description")  ;

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);

            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            //jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

        @Override
        public void sendAlert(Alert request, StreamObserver<AlertConfirmation> responseObserver) {
            try {
                alertMessages.put(request.getLocation(), request.getMessage());
                AlertConfirmation confirmation = AlertConfirmation.newBuilder()
                        .setMessage("Alert sent")
                        .setTimestamp(System.currentTimeMillis())
                        .build();
                responseObserver.onNext(confirmation);
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(Status.INTERNAL.withDescription("An error occurred: " + e.getMessage()).asRuntimeException());
            }
        }

        @Override
        public StreamObserver<Alert> broadcastAlerts(StreamObserver<AlertConfirmation> responseObserver) {
            return new StreamObserver<Alert>() {

                @Override
                public void onNext(Alert alert) {

                    try {
                        alertMessages.put(alert.getLocation(), alert.getMessage());
                        AlertConfirmation confirmation = AlertConfirmation.newBuilder()
                                .setMessage(alert.getLocation() + " --- Alert broadcasted")
                                .setTimestamp(System.currentTimeMillis())
                                .build();
                        responseObserver.onNext(confirmation);
                    } catch (Exception e) {
                        responseObserver.onError(Status.INTERNAL.withDescription("An error occurred: " + e.getMessage()).asRuntimeException());
                    }

                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Alerts broadcasted");
                    responseObserver.onCompleted();
                }
            };
        }
    }

class AuthInterceptor implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String authHeader = headers.get(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER));

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            call.close(Status.UNAUTHENTICATED.withDescription("Missing or invalid 'authorization' header"), headers);
            return new ServerCall.Listener<ReqT>() {
            };
        }

        String token = authHeader.substring("Bearer ".length());

        // Validate the token
        if (!"12345".equals(token)) {
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid token"), headers);
            return new ServerCall.Listener<ReqT>() {
            };
        }

        return next.startCall(call, headers);
    }
}


