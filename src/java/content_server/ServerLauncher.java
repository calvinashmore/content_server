package content_server;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import content_server.db.DatabaseModule;
import content_server.model.ModelModule;
import content_server.proto.HelloGrpc;
import content_server.server.ServerModule;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerLauncher {
  public static void main(String args[]) throws Exception {

    Injector injector = Guice.createInjector(new DatabaseModule(), new ModelModule(), new ServerModule());

    final ServerLauncher serverLauncher = injector.getInstance(ServerLauncher.class);
    serverLauncher.start();
    serverLauncher.blockUntilShutdown();
  }

  private final HelloGrpc.HelloImplBase hello;

  private Server server;

  @Inject
  ServerLauncher(HelloGrpc.HelloImplBase hello) {
    this.hello = hello;
  }

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 50051;
    server = ServerBuilder.forPort(port)
        .addService(hello)
        .build()
        .start();
//    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      // Use stderr here since the logger may have been reset by its JVM shutdown hook.
      System.err.println("*** shutting down gRPC server since JVM is shutting down");
      ServerLauncher.this.stop();
      System.err.println("*** server shut down");
    }));
  }
  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

}