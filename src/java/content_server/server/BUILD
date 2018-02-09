package(default_visibility = ["//visibility:public"])

java_library(
  name = 'server',
  srcs = glob(['*.java']),
  deps = [
    '@grpc_java//core',
    '@grpc_java//stub',
    '@com_google_guava_guava//jar',
    '@com_google_apis_google_api_services_sqladmin//jar',
    '@com_google_inject_guice//jar',
    '//src/java/content_server/db',
    '//src/java/content_server/model',
    '//src/proto:service_java_proto',
    '//src/proto:service_java_grpc_proto',
  ],
)
