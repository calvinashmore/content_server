package(default_visibility = ["//visibility:public"])

proto_library(
  name='dart_options',
  srcs=['dart_options.proto'],
  deps=['@com_google_protobuf_well_known_protos//:protos'],
)

proto_library(
  name='service_proto',
  srcs=['service.proto'],
  deps=[':dart_options'],
)

java_proto_library(
    name = 'service_java_proto',
    deps = [':service_proto'],
)

load("@grpc_java//:java_grpc_library.bzl", "java_grpc_library")

java_grpc_library(
    name = 'service_java_grpc_proto',
    srcs = [':service_proto'],
    deps = [':service_java_proto'],
)
