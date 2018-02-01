package(default_visibility = ["//visibility:public"])

java_library(
  name = 'db',
  srcs = glob(['*.java']),
  deps = [
      "@com_google_inject_guice//jar",
      '@org_hibernate_hibernate_core//jar',
      '@auto_value//:processor',
      '@javax_persistence_javax_persistence_api//jar',
      '//src/java/content_server/db/entity',
  ],
  resources = ['hibernate.cfg.xml'],
)

java_binary(
    name = 'SchemaExporter',
    runtime_deps = [
        ':db',
        '@org_jboss_logging_jboss_logging//jar',
        '@javax_transaction_jta//jar',
        '@dom4j_dom4j//jar',
        '@org_hibernate_common_hibernate_commons_annotations//jar',
        '@org_hibernate_javax_persistence_hibernate_jpa//jar',
        '@com_fasterxml_classmate//jar',
    ],
    main_class = 'content_server.db.SchemaExporter',
)