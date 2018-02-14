package(default_visibility = ["//visibility:public"])

java_library(
  name = 'content_server',
  srcs = glob(['*.java']),
  deps = [
    '@grpc_java//core',
    '@grpc_java//stub',
    '@com_google_guava_guava//jar',
    '@com_google_apis_google_api_services_sqladmin//jar',
    '@com_google_inject_guice//jar',
    '@io_grpc_grpc_services//jar',
    '//src/java/content_server/db',
    '//src/java/content_server/model',
    '//src/java/content_server/server',
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
      '@javax_inject_javax_inject//jar',
      '@aopalliance_aopalliance//jar',
        '@org_jboss_logging_jboss_logging//jar',
        '@dom4j_dom4j//jar',
        '@javax_transaction_jta//jar',
        '@org_hibernate_common_hibernate_commons_annotations//jar',
        '@org_hibernate_javax_persistence_hibernate_jpa//jar',
        '@com_fasterxml_classmate//jar',
        '@javassist_javassist//jar',
        '@antlr//jar',
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