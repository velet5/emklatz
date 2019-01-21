package velet5.emklatz.controller

import akka.http.scaladsl.server.Route
import velet5.emklatz.controller.directive.EmklatzDirectives
import velet5.emklatz.http.Controller

class PointController(emklatzDirectives: EmklatzDirectives) extends Controller {
  override def route: Route = ???
}
