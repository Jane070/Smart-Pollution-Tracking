package ds.alertservice;

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
    comments = "Source: alert_service.proto")
public final class AlertServiceGrpc {

  private AlertServiceGrpc() {}

  public static final String SERVICE_NAME = "AlertService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.alertservice.Alert,
      ds.alertservice.AlertConfirmation> getSendAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendAlert",
      requestType = ds.alertservice.Alert.class,
      responseType = ds.alertservice.AlertConfirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.alertservice.Alert,
      ds.alertservice.AlertConfirmation> getSendAlertMethod() {
    io.grpc.MethodDescriptor<ds.alertservice.Alert, ds.alertservice.AlertConfirmation> getSendAlertMethod;
    if ((getSendAlertMethod = AlertServiceGrpc.getSendAlertMethod) == null) {
      synchronized (AlertServiceGrpc.class) {
        if ((getSendAlertMethod = AlertServiceGrpc.getSendAlertMethod) == null) {
          AlertServiceGrpc.getSendAlertMethod = getSendAlertMethod = 
              io.grpc.MethodDescriptor.<ds.alertservice.Alert, ds.alertservice.AlertConfirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AlertService", "SendAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alertservice.Alert.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alertservice.AlertConfirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new AlertServiceMethodDescriptorSupplier("SendAlert"))
                  .build();
          }
        }
     }
     return getSendAlertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.alertservice.Alert,
      ds.alertservice.AlertConfirmation> getBroadcastAlertsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BroadcastAlerts",
      requestType = ds.alertservice.Alert.class,
      responseType = ds.alertservice.AlertConfirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.alertservice.Alert,
      ds.alertservice.AlertConfirmation> getBroadcastAlertsMethod() {
    io.grpc.MethodDescriptor<ds.alertservice.Alert, ds.alertservice.AlertConfirmation> getBroadcastAlertsMethod;
    if ((getBroadcastAlertsMethod = AlertServiceGrpc.getBroadcastAlertsMethod) == null) {
      synchronized (AlertServiceGrpc.class) {
        if ((getBroadcastAlertsMethod = AlertServiceGrpc.getBroadcastAlertsMethod) == null) {
          AlertServiceGrpc.getBroadcastAlertsMethod = getBroadcastAlertsMethod = 
              io.grpc.MethodDescriptor.<ds.alertservice.Alert, ds.alertservice.AlertConfirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AlertService", "BroadcastAlerts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alertservice.Alert.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.alertservice.AlertConfirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new AlertServiceMethodDescriptorSupplier("BroadcastAlerts"))
                  .build();
          }
        }
     }
     return getBroadcastAlertsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlertServiceStub newStub(io.grpc.Channel channel) {
    return new AlertServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlertServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AlertServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlertServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AlertServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AlertServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *    rpc SubscribeAlerts (AlertSubscription) returns (stream Alert); // server-side streaming RPC
     * </pre>
     */
    public void sendAlert(ds.alertservice.Alert request,
        io.grpc.stub.StreamObserver<ds.alertservice.AlertConfirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getSendAlertMethod(), responseObserver);
    }

    /**
     * <pre>
     * bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.alertservice.Alert> broadcastAlerts(
        io.grpc.stub.StreamObserver<ds.alertservice.AlertConfirmation> responseObserver) {
      return asyncUnimplementedStreamingCall(getBroadcastAlertsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.alertservice.Alert,
                ds.alertservice.AlertConfirmation>(
                  this, METHODID_SEND_ALERT)))
          .addMethod(
            getBroadcastAlertsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.alertservice.Alert,
                ds.alertservice.AlertConfirmation>(
                  this, METHODID_BROADCAST_ALERTS)))
          .build();
    }
  }

  /**
   */
  public static final class AlertServiceStub extends io.grpc.stub.AbstractStub<AlertServiceStub> {
    private AlertServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc SubscribeAlerts (AlertSubscription) returns (stream Alert); // server-side streaming RPC
     * </pre>
     */
    public void sendAlert(ds.alertservice.Alert request,
        io.grpc.stub.StreamObserver<ds.alertservice.AlertConfirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendAlertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.alertservice.Alert> broadcastAlerts(
        io.grpc.stub.StreamObserver<ds.alertservice.AlertConfirmation> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBroadcastAlertsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AlertServiceBlockingStub extends io.grpc.stub.AbstractStub<AlertServiceBlockingStub> {
    private AlertServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc SubscribeAlerts (AlertSubscription) returns (stream Alert); // server-side streaming RPC
     * </pre>
     */
    public ds.alertservice.AlertConfirmation sendAlert(ds.alertservice.Alert request) {
      return blockingUnaryCall(
          getChannel(), getSendAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AlertServiceFutureStub extends io.grpc.stub.AbstractStub<AlertServiceFutureStub> {
    private AlertServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *    rpc SubscribeAlerts (AlertSubscription) returns (stream Alert); // server-side streaming RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.alertservice.AlertConfirmation> sendAlert(
        ds.alertservice.Alert request) {
      return futureUnaryCall(
          getChannel().newCall(getSendAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_ALERT = 0;
  private static final int METHODID_BROADCAST_ALERTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlertServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlertServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_ALERT:
          serviceImpl.sendAlert((ds.alertservice.Alert) request,
              (io.grpc.stub.StreamObserver<ds.alertservice.AlertConfirmation>) responseObserver);
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
        case METHODID_BROADCAST_ALERTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.broadcastAlerts(
              (io.grpc.stub.StreamObserver<ds.alertservice.AlertConfirmation>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AlertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlertServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.alertservice.AlertServiceImp.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlertService");
    }
  }

  private static final class AlertServiceFileDescriptorSupplier
      extends AlertServiceBaseDescriptorSupplier {
    AlertServiceFileDescriptorSupplier() {}
  }

  private static final class AlertServiceMethodDescriptorSupplier
      extends AlertServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlertServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlertServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlertServiceFileDescriptorSupplier())
              .addMethod(getSendAlertMethod())
              .addMethod(getBroadcastAlertsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
