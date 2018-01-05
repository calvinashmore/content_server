library content_server.thing;

import 'package:angular/angular.dart';
import 'package:content_server.proto.service/service.pb.dart';

@Component(
  selector: 'thing',
  templateUrl: 'thing.html',
)
class Thing {
  var name = 'Angular';
}