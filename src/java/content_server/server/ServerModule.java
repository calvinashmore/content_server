package content_server.server;

import com.google.inject.AbstractModule;
import content_server.proto.HelloGrpc;

public class ServerModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(HelloGrpc.HelloImplBase.class).to(HelloImpl.class);
  }
}
