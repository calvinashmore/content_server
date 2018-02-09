package content_server.server;

import com.google.inject.Inject;
import content_server.db.Database;
import content_server.model.ThingModel;
import content_server.proto.HelloGrpc;
import content_server.proto.Service;
import io.grpc.stub.StreamObserver;

import java.util.Optional;

class HelloImpl extends HelloGrpc.HelloImplBase {

  private final ThingModel thingModel;

  @Inject
  HelloImpl(ThingModel thingModel) {
    this.thingModel = thingModel;
  }

  @Override
  public void putThing(Service.PutThingRequest request, StreamObserver<Service.PutThingResponse> responseObserver) {

    try {
      Optional<String> oldThing = thingModel.getThing(request.getId());
      Service.PutThingResponse.Builder response = Service.PutThingResponse.newBuilder();

      oldThing.ifPresent(response::setOldValue);

      thingModel.putThing(request.getId(), request.getThing());

      responseObserver.onNext(response.build());

    } catch (Database.DatabaseException ex) {
      responseObserver.onError(ex);
    } finally {
      responseObserver.onCompleted();
    }
  }

  @Override
  public void getThing(Service.GetThingRequest request, StreamObserver<Service.GetThingResponse> responseObserver) {

    try {
      Optional<String> oldThing = thingModel.getThing(request.getId());
      Service.GetThingResponse.Builder response = Service.GetThingResponse.newBuilder();

      oldThing.ifPresent(response::setThing);

      responseObserver.onNext(response.build());

    } catch (Database.DatabaseException ex) {
      responseObserver.onError(ex);
    } finally {
      responseObserver.onCompleted();
    }
  }
}
