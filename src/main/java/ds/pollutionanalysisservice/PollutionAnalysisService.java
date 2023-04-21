package ds.pollutionanalysisservice;

import io.grpc.*;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * ClassName: PollutionAnalysisService
 * Description:
 *
 * @Author: Jiaxin Zhang
 * @Version: 1.8
 */
public class PollutionAnalysisService extends PollutionAnalysisServiceGrpc.PollutionAnalysisServiceImplBase{

        private Random random = new Random();
        private List<String> trendingLocations = Arrays.asList("Beijing", "Shijiazhuang", "Zhengzhou");

    public static void main(String[] args) {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            // Register PollutionSensorService
            ServiceInfo pollutionAnalysisServiceInfo = ServiceInfo.create("_pollution-analysis._tcp.local.", "PollutionAnalysisService", 50052, "");
            jmdns.registerService(pollutionAnalysisServiceInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PollutionAnalysisService paService = new PollutionAnalysisService();

        int port = 50052;

        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(paService)
                    .intercept(new AuthInterceptor()) // Add the authentication interceptor
                    .build()
                    .start();

            System.out.println("Pollution Analysis Server started, listening on " + port);

            server.awaitTermination();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void getTrendingLocations(TrendingRequest request, StreamObserver<TrendingLocations> responseObserver) {
        TrendingLocations locations = TrendingLocations.newBuilder()
                .setLocations(trendingLocations.toString())
                .build();
        responseObserver.onNext(locations);
        responseObserver.onCompleted();
    }

    @Override
    public void getLiveTrends(LiveTrendsRequest request, StreamObserver<PollutionAnalysis> responseObserver) {
//        List<String> locationsList = Arrays.asList(request.getLocations().split("\\s*,\\s*"));
        for (String location : request.getLocationsList()) {
            String trend = random.nextBoolean() ? "Increasing" : "Decreasing";
            PollutionAnalysis analysis = PollutionAnalysis.newBuilder()
                    .setLocation(location)
                    .setTrend(trend)
                    .build();
            responseObserver.onNext(analysis);
        }
        responseObserver.onCompleted();
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
        if (!"2222".equals(token)) {
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid token"), headers);
            return new ServerCall.Listener<ReqT>() {
            };
        }

        return next.startCall(call, headers);
    }
}

