// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pollution_analysis_service.proto

package ds.pollutionanalysisservice;

public final class PollutionAnalysisServiceImp {
  private PollutionAnalysisServiceImp() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TrendingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TrendingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TrendingLocations_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TrendingLocations_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LiveTrendsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LiveTrendsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PollutionAnalysis_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PollutionAnalysis_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n pollution_analysis_service.proto\"\021\n\017Tr" +
      "endingRequest\"&\n\021TrendingLocations\022\021\n\tlo" +
      "cations\030\001 \001(\t\"&\n\021LiveTrendsRequest\022\021\n\tlo" +
      "cations\030\001 \003(\t\"4\n\021PollutionAnalysis\022\020\n\010lo" +
      "cation\030\001 \001(\t\022\r\n\005trend\030\002 \001(\t2\223\001\n\030Pollutio" +
      "nAnalysisService\022<\n\024GetTrendingLocations" +
      "\022\020.TrendingRequest\032\022.TrendingLocations\0229" +
      "\n\rGetLiveTrends\022\022.LiveTrendsRequest\032\022.Po" +
      "llutionAnalysis0\001B<\n\033ds.pollutionanalysi" +
      "sserviceB\033PollutionAnalysisServiceImpP\001b" +
      "\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_TrendingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TrendingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TrendingRequest_descriptor,
        new java.lang.String[] { });
    internal_static_TrendingLocations_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_TrendingLocations_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TrendingLocations_descriptor,
        new java.lang.String[] { "Locations", });
    internal_static_LiveTrendsRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_LiveTrendsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LiveTrendsRequest_descriptor,
        new java.lang.String[] { "Locations", });
    internal_static_PollutionAnalysis_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_PollutionAnalysis_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PollutionAnalysis_descriptor,
        new java.lang.String[] { "Location", "Trend", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}