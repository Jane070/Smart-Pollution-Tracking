// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: alert_service.proto

package ds.alertservice;

public interface AlertOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Alert)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string location = 1;</code>
   */
  java.lang.String getLocation();
  /**
   * <code>string location = 1;</code>
   */
  com.google.protobuf.ByteString
      getLocationBytes();

  /**
   * <code>string message = 2;</code>
   */
  java.lang.String getMessage();
  /**
   * <code>string message = 2;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();

  /**
   * <code>int64 timestamp = 3;</code>
   */
  long getTimestamp();
}