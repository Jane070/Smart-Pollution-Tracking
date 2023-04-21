package ds.pollutionsensorservice;

import io.grpc.*;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;


/**
 * ClassName: PollutionSensorService
 * Description:
 *
 * @Author: Jiaxin Zhang
 * @Version: 1.8
 */
public class PollutionSensorService extends PollutionSensorServiceGrpc.PollutionSensorServiceImplBase {

    public static void main(String[] args)  {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            // Register PollutionSensorService
            ServiceInfo pollutionSensorServiceInfo = ServiceInfo.create("_pollution-sensor._tcp.local.", "PollutionSensorService", 50051, "");
            jmdns.registerService(pollutionSensorServiceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PollutionSensorService psService = new PollutionSensorService();

        int port = 50051;

        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(psService)
                    .intercept(new AuthInterceptor()) // Add the authentication interceptor
                    .build()
                    .start();

            System.out.println("Pollution Sensor Server started, listening on " + port);

            server.awaitTermination();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


        private Random random = new Random();

        @Override
        public void getPollutionData(GetPollutionDataRequest request, StreamObserver<PollutionData> responseObserver) {
            PollutionData data = generatePollutionData(request.getLocation());
            responseObserver.onNext(data);
            responseObserver.onCompleted();
        }

        @Override
        public void getCityMultiplePollutionData(GetCityMultiplePollutionDataRequest request, StreamObserver<PollutionData> responseObserver) {
            for (int i = 0; i < 3; i++) {
                PollutionData data = generatePollutionData(request.getLocation());
                responseObserver.onNext(data);
            }
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<GetAveragePollutionDataRequest> getAveragePollutionData(StreamObserver<PollutionData> responseObserver) {
            return new StreamObserver<GetAveragePollutionDataRequest>() {
                private int count = 0;
                private double totalAirPollution = 0;
                private double totalWaterPollution = 0;

                @Override
                public void onNext(GetAveragePollutionDataRequest request) {
                    PollutionData data = generatePollutionData(request.getLocation());
                    totalAirPollution += data.getAirPollution();
                    totalWaterPollution += data.getWaterPollution();
                    count++;
                }

                @Override
                public void onError(Throwable t) {
                    // Handle error
                }

                @Override
                public void onCompleted() {
                    PollutionData averageData = PollutionData.newBuilder()
                            .setLocation("Average")
                            .setAirPollution(totalAirPollution / count)
                            .setWaterPollution(totalWaterPollution / count)
                            .setTimestamp(System.currentTimeMillis())
                            .build();
                    responseObserver.onNext(averageData);
                    responseObserver.onCompleted();
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
