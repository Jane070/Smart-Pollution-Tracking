package ds.pollutionsensorservice;

import io.grpc.*;
import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;


/**
 * ClassName: PollutionSensorService
 * @Author: Jiaxin Zhang
 * @Version: 1.8
 */
public class PollutionSensorService extends PollutionSensorServiceGrpc.PollutionSensorServiceImplBase {

    public static void main(String[] args)  {
        PollutionSensorService pollutionSensorService = new PollutionSensorService();

        Properties prop = pollutionSensorService.getProperties();

        pollutionSensorService.registerService(prop);

        int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(pollutionSensorService)
                    .build()
                    .start();

            System.out.println("Math Server started, listening on " + port);

            server.awaitTermination();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/pollution_sensor_service.properties")) {

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
            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;


            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);

            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(1000);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


        private Random random = new Random();

        @Override
        public void getPollutionData(GetPollutionDataRequest request, StreamObserver<PollutionData> responseObserver) {
            try {
                PollutionData data = generatePollutionData(request.getLocation());
                responseObserver.onNext(data);
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(Status.INTERNAL.withDescription("An error occurred: " + e.getMessage()).asRuntimeException());
            }
        }

        @Override
        public void getCityMultiplePollutionData(GetCityMultiplePollutionDataRequest request,
                                                 StreamObserver<PollutionData> responseObserver) {
            try {
                for (int i = 0; i < 3; i++) {
                    PollutionData data = generatePollutionData(request.getLocation());
                    responseObserver.onNext(data);
                }
                responseObserver.onCompleted();
            } catch (Exception e) {
                responseObserver.onError(Status.INTERNAL.withDescription("An error occurred: " + e.getMessage()).asRuntimeException());
            }
        }

        @Override
        public StreamObserver<GetAveragePollutionDataRequest> getAveragePollutionData(StreamObserver<PollutionData> responseObserver) {
            return new StreamObserver<GetAveragePollutionDataRequest>() {
                private int count = 0;
                private double totalAirPollution = 0;
                private double totalWaterPollution = 0;

                @Override
                public void onNext(GetAveragePollutionDataRequest request) {
                    try {
                        PollutionData data = generatePollutionData(request.getLocation());
                        totalAirPollution += data.getAirPollution();
                        totalWaterPollution += data.getWaterPollution();
                        count++;
                    }catch (Exception e){
                        onError(Status.INTERNAL.withDescription("An error occurred: " + e.getMessage()).asRuntimeException());
                    }

                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    try {
                        PollutionData averageData = PollutionData.newBuilder()
                                .setLocation("Average")
                                .setAirPollution(totalAirPollution / count)
                                .setWaterPollution(totalWaterPollution / count)
                                .setTimestamp(System.currentTimeMillis())
                                .build();
                        responseObserver.onNext(averageData);
                        responseObserver.onCompleted();
                    }catch (Exception e){
                        responseObserver.onError(Status.INTERNAL.withDescription("An error occurred: " + e.getMessage()).asRuntimeException());
                    }

                }
            };
        }

    private PollutionData generatePollutionData(String location) {
            return PollutionData.newBuilder()
                    .setLocation(location)
                    .setAirPollution(50 + random.nextDouble() * 100)
                    .setWaterPollution(50 + random.nextDouble() * 100)
                    .setTimestamp(System.currentTimeMillis())
                    .build();
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
        if (!"1111".equals(token)) {
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid token"), headers);
            return new ServerCall.Listener<ReqT>() {
            };
        }

        return next.startCall(call, headers);
    }
}
