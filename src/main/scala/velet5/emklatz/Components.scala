package velet5.emklatz

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import velet5.emklatz.controller.PointController
import velet5.emklatz.http.Endpoint

import scala.concurrent.ExecutionContext

trait Components {

  implicit val executionContext: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global
  implicit val actorSystem: ActorSystem = ActorSystem("default")
  implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()

  val pointController = new PointController

  val apiEndpoint = new Endpoint(
    controllers = Seq(pointController),
    interface = ???,
    port = ???
  )

}
