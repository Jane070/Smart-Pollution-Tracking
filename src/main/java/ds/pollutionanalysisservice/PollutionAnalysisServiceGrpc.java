package ds.pollutionanalysisservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: pollution_analysis_service.proto")
public final class PollutionAnalysisServiceGrpc {

  private PollutionAnalysisServiceGrpc() {}

  public static final String SERVICE_NAME = "PollutionAnalysisService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.pollutionanalysisservice.TrendingRequest,
      ds.pollutionanalysisservice.TrendingLocations> getGetTrendingLocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrendingLocations",
      requestType = ds.pollutionanalysisservice.TrendingRequest.class,
      responseType = ds.pollutionanalysisservice.TrendingLocations.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.pollutionanalysisservice.TrendingRequest,
      ds.pollutionanalysisservice.TrendingLocations> getGetTrendingLocationsMethod() {
    io.grpc.MethodDescriptor<ds.pollutionanalysisservice.TrendingRequest, ds.pollutionanalysisservice.TrendingLocations> getGetTrendingLocationsMethod;
    if ((getGetTrendingLocationsMethod = PollutionAnalysisServiceGrpc.getGetTrendingLocationsMethod) == null) {
      synchronized (PollutionAnalysisServiceGrpc.class) {
        if ((getGetTrendingLocationsMethod = PollutionAnalysisServiceGrpc.getGetTrendingLocationsMethod) == null) {
          PollutionAnalysisServiceGrpc.getGetTrendingLocationsMethod = getGetTrendingLocationsMethod = 
              io.grpc.MethodDescriptor.<ds.pollutionanalysisservice.TrendingRequest, ds.pollutionanalysisservice.TrendingLocations>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PollutionAnalysisService", "GetTrendingLocations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionanalysisservice.TrendingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionanalysisservice.TrendingLocations.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionAnalysisServiceMethodDescriptorSupplier("GetTrendingLocations"))
                  .build();
          }
        }
     }
     return getGetTrendingLocationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.pollutionanalysisservice.LiveTrendsRequest,
      ds.pollutionanalysisservice.PollutionAnalysis> getGetLiveTrendsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLiveTrends",
      requestType = ds.pollutionanalysisservice.LiveTrendsRequest.class,
      responseType = ds.pollutionanalysisservice.PollutionAnalysis.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.pollutionanalysisservice.LiveTrendsRequest,
      ds.pollutionanalysisservice.PollutionAnalysis> getGetLiveTrendsMethod() {
    io.grpc.MethodDescriptor<ds.pollutionanalysisservice.LiveTrendsRequest, ds.pollutionanalysisservice.PollutionAnalysis> getGetLiveTrendsMethod;
    if ((getGetLiveTrendsMethod = PollutionAnalysisServiceGrpc.getGetLiveTrendsMethod) == null) {
      synchronized (PollutionAnalysisServiceGrpc.class) {
        if ((getGetLiveTrendsMethod = PollutionAnalysisServiceGrpc.getGetLiveTrendsMethod) == null) {
          PollutionAnalysisServiceGrpc.getGetLiveTrendsMethod = getGetLiveTrendsMethod = 
              io.grpc.MethodDescriptor.<ds.pollutionanalysisservice.LiveTrendsRequest, ds.pollutionanalysisservice.PollutionAnalysis>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PollutionAnalysisService", "GetLiveTrends"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionanalysisservice.LiveTrendsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionanalysisservice.PollutionAnalysis.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionAnalysisServiceMethodDescriptorSupplier("GetLiveTrends"))
                  .build();
          }
        }
     }
     return getGetLiveTrendsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PollutionAnalysisServiceStub newStub(io.grpc.Channel channel) {
    return new PollutionAnalysisServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PollutionAnalysisServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PollutionAnalysisServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PollutionAnalysisServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PollutionAnalysisServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PollutionAnalysisServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *    rpc AnalyzePollution (stream PollutionData) returns (PollutionAnalysis); // client-side streaming RPC
     * </pre>
     */
    public void getTrendingLocations(ds.pollutionanalysisservice.TrendingRequest request,
        io.grpc.stub.StreamObserver<ds.pollutionanalysisservice.TrendingLocations> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTrendingLocationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * server-side streaming RPC
     * </pre>
     */
    public void getLiveTrends(ds.pollutionanalysisservice.LiveTrendsRequest request,
        io.grpc.stub.StreamObserver<ds.pollutionanalysisservice.PollutionAnalysis> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLiveTrendsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTrendingLocationsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.pollutionanalysisservice.TrendingRequest,
                ds.pollutionanalysisservice.TrendingLocations>(
                  this, METHODID_GET_TRENDING_LOCATIONS)))
          .addMethod(
            getGetLiveTrendsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.pollutionanalysisservice.LiveTrendsRequest,
                ds.pollutionanalysisservice.PollutionAnalysis>(
                  this, METHODID_GET_LIVE_TRENDS)))
          .build();
    }
  }

  /**
   */
  public static final class PollutionAnalysisServiceStub extends io.grpc.stub.AbstractStub<PollutionAnalysisServiceStub> {
    private PollutionAnalysisServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionAnalysisServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionAnalysisServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionAnalysisServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc AnalyzePollution (stream PollutionData) returns (PollutionAnalysis); // client-side streaming RPC
     * </pre>
     */
    public void getTrendingLocations(ds.pollutionanalysisservice.TrendingRequest request,
        io.grpc.stub.StreamObserver<ds.pollutionanalysisservice.TrendingLocations> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTrendingLocationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server-side streaming RPC
     * </pre>
     */
    public void getLiveTrends(ds.pollutionanalysisservice.LiveTrendsRequest request,
        io.grpc.stub.StreamObserver<ds.pollutionanalysisservice.PollutionAnalysis> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetLiveTrendsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PollutionAnalysisServiceBlockingStub extends io.grpc.stub.AbstractStub<PollutionAnalysisServiceBlockingStub> {
    private PollutionAnalysisServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionAnalysisServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionAnalysisServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionAnalysisServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc AnalyzePollution (stream PollutionData) returns (PollutionAnalysis); // client-side streaming RPC
     * </pre>
     */
    public ds.pollutionanalysisservice.TrendingLocations getTrendingLocations(ds.pollutionanalysisservice.TrendingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTrendingLocationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server-side streaming RPC
     * </pre>
     */
    public java.util.Iterator<ds.pollutionanalysisservice.PollutionAnalysis> getLiveTrends(
        ds.pollutionanalysisservice.LiveTrendsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetLiveTrendsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PollutionAnalysisServiceFutureStub extends io.grpc.stub.AbstractStub<PollutionAnalysisServiceFutureStub> {
    private PollutionAnalysisServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionAnalysisServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionAnalysisServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionAnalysisServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc AnalyzePollution (stream PollutionData) returns (PollutionAnalysis); // client-side streaming RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.pollutionanalysisservice.TrendingLocations> getTrendingLocations(
        ds.pollutionanalysisservice.TrendingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTrendingLocationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TRENDING_LOCATIONS = 0;
  private static final int METHODID_GET_LIVE_TRENDS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PollutionAnalysisServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PollutionAnalysisServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TRENDING_LOCATIONS:
          serviceImpl.getTrendingLocations((ds.pollutionanalysisservice.TrendingRequest) request,
              (io.grpc.stub.StreamObserver<ds.pollutionanalysisservice.TrendingLocations>) responseObserver);
          break;
        case METHODID_GET_LIVE_TRENDS:
          serviceImpl.getLiveTrends((ds.pollutionanalysisservice.LiveTrendsRequest) request,
              (io.grpc.stub.StreamObserver<ds.pollutionanalysisservice.PollutionAnalysis>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PollutionAnalysisServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PollutionAnalysisServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.pollutionanalysisservice.PollutionAnalysisServiceImp.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PollutionAnalysisService");
    }
  }

  private static final class PollutionAnalysisServiceFileDescriptorSupplier
      extends PollutionAnalysisServiceBaseDescriptorSupplier {
    PollutionAnalysisServiceFileDescriptorSupplier() {}
  }

  private static final class PollutionAnalysisServiceMethodDescriptorSupplier
      extends PollutionAnalysisServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PollutionAnalysisServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PollutionAnalysisServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PollutionAnalysisServiceFileDescriptorSupplier())
              .addMethod(getGetTrendingLocationsMethod())
              .addMethod(getGetLiveTrendsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
