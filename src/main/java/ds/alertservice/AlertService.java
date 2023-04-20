package ds.alertservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ClassName: AlertService
 * Description:
 *
 * @Author: Jiaxin Zhang
 * @Creat: 11/04/2023 17:16
 * @Version: 1.8
 */
public class AlertService extends AlertServiceGrpc.AlertServiceImplBase{

        private Random random = new Random();
        private Map<String, String> alertMessages = new HashMap<>();

    public static void main(String[] args) {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            // Register PollutionSensorService
            ServiceInfo alertServiceInfo = ServiceInfo.create("_alert-service._tcp.local.", "AlertService", 50053, "");
            jmdns.registerService(alertServiceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AlertService alertService = new AlertService();

        int port = 50053;


        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(alertService)
                    .build()
                    .start();

            System.out.println("Alert Server started, listening on " + port);

            server.awaitTermination();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//        @Override
//        public void subscribeAlerts(AlertSubscription request, StreamObserver<Alert> responseObserver) {
//            String location = request.getLocation();
//            for (int i = 0; i < 5; i++) {
//                String message = alertMessages.getOrDefault(location, "No alerts");
//                Alert alert = Alert.newBuilder()
//                        .setLocation(location)
//                        .setMessage(message)
//                        .setTimestamp(System.currentTimeMillis())
//                        .build();
//                responseObserver.onNext(alert);
//            }
//            responseObserver.onCompleted();
//        }

        @Override
        public void sendAlert(Alert request, StreamObserver<AlertConfirmation> responseObserver) {
            alertMessages.put(request.getLocation(), request.getMessage());
            AlertConfirmation confirmation = AlertConfirmation.newBuilder()
                    .setMessage("Alert sent")
                    .setTimestamp(System.currentTimeMillis())
                    .build();
            responseObserver.onNext(confirmation);
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<Alert> broadcastAlerts(StreamObserver<AlertConfirmation> responseObserver) {
            return new StreamObserver<Alert>() {

                @Override
                public void onNext(Alert alert) {
                    alertMessages.put(alert.getLocation(), alert.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    // Handle error
                }

                @Override
                public void onCompleted() {
                    AlertConfirmation confirmation = AlertConfirmation.newBuilder()
                            .setMessage(" Alert broadcasted")
                            .setTimestamp(System.currentTimeMillis())
                            .build();
                    responseObserver.onNext(confirmation);
                    responseObserver.onCompleted();
                }
            };
        }
    }


