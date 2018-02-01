package(default_visibility = ["//visibility:public"])

java_library(
  name = 'model',
  srcs = glob(['*.java']),
  deps = [
      "@com_google_inject_guice//jar",
      '@org_hibernate_hibernate_core//jar',
      '@auto_value//:processor',
      '@javax_persistence_javax_persistence_api//jar',
      '//src/java/content_server/db',
      '//src/java/content_server/db/entity',
  ],
)