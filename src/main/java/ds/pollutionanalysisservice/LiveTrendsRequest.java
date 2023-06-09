// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pollution_analysis_service.proto

package ds.pollutionanalysisservice;

/**
 * Protobuf type {@code LiveTrendsRequest}
 */
public  final class LiveTrendsRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:LiveTrendsRequest)
    LiveTrendsRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LiveTrendsRequest.newBuilder() to construct.
  private LiveTrendsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LiveTrendsRequest() {
    locations_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LiveTrendsRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              locations_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            locations_.add(s);
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        locations_ = locations_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.pollutionanalysisservice.PollutionAnalysisServiceImp.internal_static_LiveTrendsRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.pollutionanalysisservice.PollutionAnalysisServiceImp.internal_static_LiveTrendsRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.pollutionanalysisservice.LiveTrendsRequest.class, ds.pollutionanalysisservice.LiveTrendsRequest.Builder.class);
  }

  public static final int LOCATIONS_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList locations_;
  /**
   * <code>repeated string locations = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getLocationsList() {
    return locations_;
  }
  /**
   * <code>repeated string locations = 1;</code>
   */
  public int getLocationsCount() {
    return locations_.size();
  }
  /**
   * <code>repeated string locations = 1;</code>
   */
  public java.lang.String getLocations(int index) {
    return locations_.get(index);
  }
  /**
   * <code>repeated string locations = 1;</code>
   */
  public com.google.protobuf.ByteString
      getLocationsBytes(int index) {
    return locations_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < locations_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, locations_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < locations_.size(); i++) {
        dataSize += computeStringSizeNoTag(locations_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getLocationsList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.pollutionanalysisservice.LiveTrendsRequest)) {
      return super.equals(obj);
    }
    ds.pollutionanalysisservice.LiveTrendsRequest other = (ds.pollutionanalysisservice.LiveTrendsRequest) obj;

    boolean result = true;
    result = result && getLocationsList()
        .equals(other.getLocationsList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getLocationsCount() > 0) {
      hash = (37 * hash) + LOCATIONS_FIELD_NUMBER;
      hash = (53 * hash) + getLocationsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.pollutionanalysisservice.LiveTrendsRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.pollutionanalysisservice.LiveTrendsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code LiveTrendsRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:LiveTrendsRequest)
      ds.pollutionanalysisservice.LiveTrendsRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.pollutionanalysisservice.PollutionAnalysisServiceImp.internal_static_LiveTrendsRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.pollutionanalysisservice.PollutionAnalysisServiceImp.internal_static_LiveTrendsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.pollutionanalysisservice.LiveTrendsRequest.class, ds.pollutionanalysisservice.LiveTrendsRequest.Builder.class);
    }

    // Construct using ds.pollutionanalysisservice.LiveTrendsRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      locations_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.pollutionanalysisservice.PollutionAnalysisServiceImp.internal_static_LiveTrendsRequest_descriptor;
    }

    @java.lang.Override
    public ds.pollutionanalysisservice.LiveTrendsRequest getDefaultInstanceForType() {
      return ds.pollutionanalysisservice.LiveTrendsRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.pollutionanalysisservice.LiveTrendsRequest build() {
      ds.pollutionanalysisservice.LiveTrendsRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.pollutionanalysisservice.LiveTrendsRequest buildPartial() {
      ds.pollutionanalysisservice.LiveTrendsRequest result = new ds.pollutionanalysisservice.LiveTrendsRequest(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        locations_ = locations_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.locations_ = locations_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.pollutionanalysisservice.LiveTrendsRequest) {
        return mergeFrom((ds.pollutionanalysisservice.LiveTrendsRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.pollutionanalysisservice.LiveTrendsRequest other) {
      if (other == ds.pollutionanalysisservice.LiveTrendsRequest.getDefaultInstance()) return this;
      if (!other.locations_.isEmpty()) {
        if (locations_.isEmpty()) {
          locations_ = other.locations_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureLocationsIsMutable();
          locations_.addAll(other.locations_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.pollutionanalysisservice.LiveTrendsRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.pollutionanalysisservice.LiveTrendsRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList locations_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureLocationsIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        locations_ = new com.google.protobuf.LazyStringArrayList(locations_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getLocationsList() {
      return locations_.getUnmodifiableView();
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public int getLocationsCount() {
      return locations_.size();
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public java.lang.String getLocations(int index) {
      return locations_.get(index);
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public com.google.protobuf.ByteString
        getLocationsBytes(int index) {
      return locations_.getByteString(index);
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public Builder setLocations(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureLocationsIsMutable();
      locations_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public Builder addLocations(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureLocationsIsMutable();
      locations_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public Builder addAllLocations(
        java.lang.Iterable<java.lang.String> values) {
      ensureLocationsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, locations_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public Builder clearLocations() {
      locations_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string locations = 1;</code>
     */
    public Builder addLocationsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureLocationsIsMutable();
      locations_.add(value);
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:LiveTrendsRequest)
  }

  // @@protoc_insertion_point(class_scope:LiveTrendsRequest)
  private static final ds.pollutionanalysisservice.LiveTrendsRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.pollutionanalysisservice.LiveTrendsRequest();
  }

  public static ds.pollutionanalysisservice.LiveTrendsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LiveTrendsRequest>
      PARSER = new com.google.protobuf.AbstractParser<LiveTrendsRequest>() {
    @java.lang.Override
    public LiveTrendsRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LiveTrendsRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LiveTrendsRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LiveTrendsRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.pollutionanalysisservice.LiveTrendsRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

