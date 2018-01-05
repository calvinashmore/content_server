package(default_visibility = ["//visibility:public"])

java_library(
  name = 'content_server',
  srcs = glob(['*.java']),
  deps = [
    '@grpc_java//core',
    '@grpc_java//stub',
    '@com_google_guava_guava//jar',
    '@com_google_apis_google_api_services_sqladmin//jar',
    '//src/proto:service_java_proto',
    '//src/proto:service_java_grpc_proto',
  ],
  runtime_deps = [
      '@com_google_cloud_sql_mysql_socket_factory//jar',
      '@mysql_mysql_connector_java//jar',
      '@com_google_cloud_sql_mysql_socket_factory_core//jar',
      '@com_google_api_client_google_api_client//jar',
      '@com_google_http_client_google_http_client//jar',
      '@com_google_http_client_google_http_client_jackson2//jar',
      '@com_google_oauth_client_google_oauth_client//jar',
      '@com_fasterxml_jackson_core_jackson_core//jar',
  ],
)

java_binary(
  name = 'ServerLauncher',
  runtime_deps = [
      ':content_server',
      '@grpc_java//netty',
  ],
  main_class = 'content_server.ServerLauncher',
)