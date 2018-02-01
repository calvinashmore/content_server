maven_jar(
  name = "com_google_guava_guava",
  artifact = "com.google.guava:guava:19.0",
  sha1 = "6ce200f6b23222af3d8abb6b6459e6c44f4bb0e9",
)

maven_jar(
  name = "com_google_inject_guice",
  artifact = "com.google.inject:guice:4.0",
)

maven_jar(
  name = "javax_inject_javax_inject",
  artifact = "javax.inject:javax.inject:1",
)

maven_jar(
  name = "aopalliance_aopalliance",
  artifact = "aopalliance:aopalliance:1.0",
)


maven_jar(
  name = "javassist_javassist",
  artifact = "javassist:javassist:3.12.1.GA",
)

#maven_jar(
#  name = "org_antlr_antlr_runtime",
#  artifact = "org.antlr:antlr-runtime:3.5.2",
#)

http_jar(
    name = "antlr",
    url = "http://www.antlr3.org/download/antlr-3.5.2-complete.jar",
)


#maven_jar(
#    name = "com_google_auto_value_auto_value",
#    artifact = "com.google.auto.value:auto-value:1.5.3",
#)

new_http_archive(
    name = "auto_value",
    url = "http://repo1.maven.org/maven2/com/google/auto/value/auto-value/1.5.3/auto-value-1.5.3.jar",
    build_file_content = """
java_import(
    name = "jar",
    jars = ["auto-value-1.5.3.jar"],
)

java_plugin(
    name = "autovalue-plugin",
    generates_api = 1,
    processor_class = "com.google.auto.value.processor.AutoValueProcessor",
    deps = [":jar"],
)

java_library(
    name = "processor",
    exported_plugins = [":autovalue-plugin"],
    exports = [":jar"],
    visibility = ["//visibility:public"],
)
""",
)

maven_jar(
  name =  "com_fasterxml_jackson_core_jackson_core",
  artifact = "com.fasterxml.jackson.core:jackson-core:2.9.3",
)

maven_jar(
  name = "com_google_apis_google_api_services_sqladmin",
  artifact = "com.google.apis:google-api-services-sqladmin:v1beta4-rev48-1.23.0",
)

maven_jar(
  name = "com_google_api_client_google_api_client",
  artifact = "com.google.api-client:google-api-client:1.23.0",
)

maven_jar(
  name =  "com_google_oauth_client_google_oauth_client",
  artifact = "com.google.oauth-client:google-oauth-client:1.23.0",
)

maven_jar(
  name = "com_google_http_client_google_http_client",
  artifact = "com.google.http-client:google-http-client:1.23.0",
)

maven_jar(
  name = "com_google_http_client_google_http_client_jackson2",
  artifact = "com.google.http-client:google-http-client-jackson2:1.23.0",
)

maven_jar(
  name = "com_google_cloud_sql_mysql_socket_factory",
  artifact = "com.google.cloud.sql:mysql-socket-factory:1.0.4",
)

maven_jar(
  name = "com_google_cloud_sql_mysql_socket_factory_core",
  artifact = "com.google.cloud.sql:jdbc-socket-factory-core:1.0.4",
)

maven_jar(
  name = "mysql_mysql_connector_java",
  artifact = "mysql:mysql-connector-java:5.1.38",
)

maven_jar(
    name = "org_hibernate_hibernate_core",
    artifact = "org.hibernate:hibernate-core:5.2.12.Final",
)

maven_jar(
    name = "org_hibernate_common_hibernate_commons_annotations",
    artifact = "org.hibernate.common:hibernate-commons-annotations:5.0.1.Final",
)

maven_jar(
    name = "org_hibernate_javax_persistence_hibernate_jpa",
    artifact = "org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.0.Final",
)

maven_jar(
    name = "org_jboss_logging_jboss_logging",
    artifact = "org.jboss.logging:jboss-logging:3.3.1.Final",
)

maven_jar(
    name = "javax_transaction_jta",
    artifact = "javax.transaction:jta:1.1",
)

maven_jar(
    name = "dom4j_dom4j",
    artifact = "dom4j:dom4j:1.6.1",
)

maven_jar(
    name = "com_fasterxml_classmate",
    artifact = "com.fasterxml:classmate:1.3.4",
)

maven_jar(
    name = "javax_persistence_javax_persistence_api",
    artifact = "javax.persistence:javax.persistence-api:2.2",
)

http_archive(
    name = "com_google_protobuf",
    urls = ["https://github.com/google/protobuf/archive/b4b0e304be5a68de3d0ee1af9b286f958750f5e4.zip"],
    strip_prefix = "protobuf-b4b0e304be5a68de3d0ee1af9b286f958750f5e4",
    sha256 = "ff771a662fb6bd4d3cc209bcccedef3e93980a49f71df1e987f6afa3bcdcba3a",
)

load("//:well_known_protos.bzl", "proto_repositories")
proto_repositories()

http_archive(
    name = "com_google_protobuf_java",
    urls = ["https://github.com/google/protobuf/archive/b4b0e304be5a68de3d0ee1af9b286f958750f5e4.zip"],
    strip_prefix = "protobuf-b4b0e304be5a68de3d0ee1af9b286f958750f5e4",
    sha256 = "ff771a662fb6bd4d3cc209bcccedef3e93980a49f71df1e987f6afa3bcdcba3a",
)

git_repository(
    name = "grpc_java",
    remote = "git@github.com:grpc/grpc-java.git",
    tag = "v1.8.0",
)

load("@grpc_java//:repositories.bzl", "grpc_java_repositories")
grpc_java_repositories(
    omit_com_google_guava=True,
    omit_com_google_protobuf=True,
    omit_com_google_protobuf_java=True,
)


# Dart -> Proto:
# pub global activate protoc_plugin
# export PATH="$PATH":"/Users/ashmore/.pub-cache/bin"
# protoc --dart_out=bazel-genfiles/ src/proto/service.proto
# protoc --dart_out=bazel-genfiles/src/proto/service/lib --proto_path=src/proto src/proto/service.proto


#git_repository(
#  name = "io_bazel_rules_dart",
#  remote = "git@github.com:dart-lang/rules_dart.git",
#  tag = "v0.4.9",
#)
#
#load("@io_bazel_rules_dart//dart/build_rules:core.bzl", "dart_library")
#load("@io_bazel_rules_dart//dart/build_rules:web.bzl", "dart_web_application")