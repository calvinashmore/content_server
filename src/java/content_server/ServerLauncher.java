package content_server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import com.google.common.collect.ImmutableList;
import content_server.proto.Service;
import content_server.proto.Service.Stuff;
import content_server.proto.HelloGrpc.HelloImplBase;
import com.google.api.services.sqladmin.SQLAdmin;

import java.io.IOException;

public class ServerLauncher {
  public static void main(String args[]) throws Exception {
//    final ServerLauncher server = new ServerLauncher();
//    server.start();
//    server.blockUntilShutdown();

    new DatabaseThing().connect();
  }


  private Server server;

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 50051;
    server = ServerBuilder.forPort(port)
        .addService(new HelloImpl())
        .build()
        .start();
//    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        ServerLauncher.this.stop();
        System.err.println("*** server shut down");
      }
    });
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

  private class HelloImpl extends HelloImplBase {
    @Override
    public void sayHello(Service.HelloRequest request, StreamObserver<Service.HelloReply> responseObserver) {
      Service.HelloReply reply = Service.HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
  }
}