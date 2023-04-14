package ds.pollutionsensorservice;

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
    comments = "Source: pollution_sensor_service.proto")
public final class PollutionSensorServiceGrpc {

  private PollutionSensorServiceGrpc() {}

  public static final String SERVICE_NAME = "PollutionSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetPollutionDataRequest,
      ds.pollutionsensorservice.PollutionData> getGetPollutionDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPollutionData",
      requestType = ds.pollutionsensorservice.GetPollutionDataRequest.class,
      responseType = ds.pollutionsensorservice.PollutionData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetPollutionDataRequest,
      ds.pollutionsensorservice.PollutionData> getGetPollutionDataMethod() {
    io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetPollutionDataRequest, ds.pollutionsensorservice.PollutionData> getGetPollutionDataMethod;
    if ((getGetPollutionDataMethod = PollutionSensorServiceGrpc.getGetPollutionDataMethod) == null) {
      synchronized (PollutionSensorServiceGrpc.class) {
        if ((getGetPollutionDataMethod = PollutionSensorServiceGrpc.getGetPollutionDataMethod) == null) {
          PollutionSensorServiceGrpc.getGetPollutionDataMethod = getGetPollutionDataMethod = 
              io.grpc.MethodDescriptor.<ds.pollutionsensorservice.GetPollutionDataRequest, ds.pollutionsensorservice.PollutionData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PollutionSensorService", "GetPollutionData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionsensorservice.GetPollutionDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionsensorservice.PollutionData.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionSensorServiceMethodDescriptorSupplier("GetPollutionData"))
                  .build();
          }
        }
     }
     return getGetPollutionDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest,
      ds.pollutionsensorservice.PollutionData> getGetCityMultiplePollutionDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCityMultiplePollutionData",
      requestType = ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest.class,
      responseType = ds.pollutionsensorservice.PollutionData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest,
      ds.pollutionsensorservice.PollutionData> getGetCityMultiplePollutionDataMethod() {
    io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest, ds.pollutionsensorservice.PollutionData> getGetCityMultiplePollutionDataMethod;
    if ((getGetCityMultiplePollutionDataMethod = PollutionSensorServiceGrpc.getGetCityMultiplePollutionDataMethod) == null) {
      synchronized (PollutionSensorServiceGrpc.class) {
        if ((getGetCityMultiplePollutionDataMethod = PollutionSensorServiceGrpc.getGetCityMultiplePollutionDataMethod) == null) {
          PollutionSensorServiceGrpc.getGetCityMultiplePollutionDataMethod = getGetCityMultiplePollutionDataMethod = 
              io.grpc.MethodDescriptor.<ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest, ds.pollutionsensorservice.PollutionData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PollutionSensorService", "GetCityMultiplePollutionData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionsensorservice.PollutionData.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionSensorServiceMethodDescriptorSupplier("GetCityMultiplePollutionData"))
                  .build();
          }
        }
     }
     return getGetCityMultiplePollutionDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetAveragePollutionDataRequest,
      ds.pollutionsensorservice.PollutionData> getGetAveragePollutionDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAveragePollutionData",
      requestType = ds.pollutionsensorservice.GetAveragePollutionDataRequest.class,
      responseType = ds.pollutionsensorservice.PollutionData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetAveragePollutionDataRequest,
      ds.pollutionsensorservice.PollutionData> getGetAveragePollutionDataMethod() {
    io.grpc.MethodDescriptor<ds.pollutionsensorservice.GetAveragePollutionDataRequest, ds.pollutionsensorservice.PollutionData> getGetAveragePollutionDataMethod;
    if ((getGetAveragePollutionDataMethod = PollutionSensorServiceGrpc.getGetAveragePollutionDataMethod) == null) {
      synchronized (PollutionSensorServiceGrpc.class) {
        if ((getGetAveragePollutionDataMethod = PollutionSensorServiceGrpc.getGetAveragePollutionDataMethod) == null) {
          PollutionSensorServiceGrpc.getGetAveragePollutionDataMethod = getGetAveragePollutionDataMethod = 
              io.grpc.MethodDescriptor.<ds.pollutionsensorservice.GetAveragePollutionDataRequest, ds.pollutionsensorservice.PollutionData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PollutionSensorService", "GetAveragePollutionData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionsensorservice.GetAveragePollutionDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.pollutionsensorservice.PollutionData.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionSensorServiceMethodDescriptorSupplier("GetAveragePollutionData"))
                  .build();
          }
        }
     }
     return getGetAveragePollutionDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PollutionSensorServiceStub newStub(io.grpc.Channel channel) {
    return new PollutionSensorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PollutionSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PollutionSensorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PollutionSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PollutionSensorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PollutionSensorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * simple RPC
     * </pre>
     */
    public void getPollutionData(ds.pollutionsensorservice.GetPollutionDataRequest request,
        io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPollutionDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * server-side streaming RPC
     * </pre>
     */
    public void getCityMultiplePollutionData(ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest request,
        io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCityMultiplePollutionDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * client-side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.pollutionsensorservice.GetAveragePollutionDataRequest> getAveragePollutionData(
        io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetAveragePollutionDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPollutionDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.pollutionsensorservice.GetPollutionDataRequest,
                ds.pollutionsensorservice.PollutionData>(
                  this, METHODID_GET_POLLUTION_DATA)))
          .addMethod(
            getGetCityMultiplePollutionDataMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest,
                ds.pollutionsensorservice.PollutionData>(
                  this, METHODID_GET_CITY_MULTIPLE_POLLUTION_DATA)))
          .addMethod(
            getGetAveragePollutionDataMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.pollutionsensorservice.GetAveragePollutionDataRequest,
                ds.pollutionsensorservice.PollutionData>(
                  this, METHODID_GET_AVERAGE_POLLUTION_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class PollutionSensorServiceStub extends io.grpc.stub.AbstractStub<PollutionSensorServiceStub> {
    private PollutionSensorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionSensorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionSensorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionSensorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * simple RPC
     * </pre>
     */
    public void getPollutionData(ds.pollutionsensorservice.GetPollutionDataRequest request,
        io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPollutionDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server-side streaming RPC
     * </pre>
     */
    public void getCityMultiplePollutionData(ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest request,
        io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetCityMultiplePollutionDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * client-side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.pollutionsensorservice.GetAveragePollutionDataRequest> getAveragePollutionData(
        io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetAveragePollutionDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PollutionSensorServiceBlockingStub extends io.grpc.stub.AbstractStub<PollutionSensorServiceBlockingStub> {
    private PollutionSensorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionSensorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionSensorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionSensorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * simple RPC
     * </pre>
     */
    public ds.pollutionsensorservice.PollutionData getPollutionData(ds.pollutionsensorservice.GetPollutionDataRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPollutionDataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server-side streaming RPC
     * </pre>
     */
    public java.util.Iterator<ds.pollutionsensorservice.PollutionData> getCityMultiplePollutionData(
        ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetCityMultiplePollutionDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PollutionSensorServiceFutureStub extends io.grpc.stub.AbstractStub<PollutionSensorServiceFutureStub> {
    private PollutionSensorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionSensorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionSensorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionSensorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * simple RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.pollutionsensorservice.PollutionData> getPollutionData(
        ds.pollutionsensorservice.GetPollutionDataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPollutionDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_POLLUTION_DATA = 0;
  private static final int METHODID_GET_CITY_MULTIPLE_POLLUTION_DATA = 1;
  private static final int METHODID_GET_AVERAGE_POLLUTION_DATA = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PollutionSensorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PollutionSensorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_POLLUTION_DATA:
          serviceImpl.getPollutionData((ds.pollutionsensorservice.GetPollutionDataRequest) request,
              (io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData>) responseObserver);
          break;
        case METHODID_GET_CITY_MULTIPLE_POLLUTION_DATA:
          serviceImpl.getCityMultiplePollutionData((ds.pollutionsensorservice.GetCityMultiplePollutionDataRequest) request,
              (io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData>) responseObserver);
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
        case METHODID_GET_AVERAGE_POLLUTION_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getAveragePollutionData(
              (io.grpc.stub.StreamObserver<ds.pollutionsensorservice.PollutionData>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PollutionSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PollutionSensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.pollutionsensorservice.PollutionSensorServiceImp.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PollutionSensorService");
    }
  }

  private static final class PollutionSensorServiceFileDescriptorSupplier
      extends PollutionSensorServiceBaseDescriptorSupplier {
    PollutionSensorServiceFileDescriptorSupplier() {}
  }

  private static final class PollutionSensorServiceMethodDescriptorSupplier
      extends PollutionSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PollutionSensorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PollutionSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PollutionSensorServiceFileDescriptorSupplier())
              .addMethod(getGetPollutionDataMethod())
              .addMethod(getGetCityMultiplePollutionDataMethod())
              .addMethod(getGetAveragePollutionDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
