package velet5.emklatz

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import velet5.emklatz.controller.PointController
import velet5.emklatz.controller.directive.EmklatzDirectives
import velet5.emklatz.http.Endpoint

import scala.concurrent.ExecutionContext

trait Components extends Core {

  protected implicit val executionContext: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global
  protected implicit val actorSystem: ActorSystem = ActorSystem("default")
  protected implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()

  protected val emklatzDirectives = new EmklatzDirectives

  protected val pointController = new PointController(emklatzDirectives)
  private val endpointConfiguration = configuration.endpoint

  val apiEndpoint = new Endpoint(
    controllers = Seq(pointController),
    interface = endpointConfiguration.interface,
    port = endpointConfiguration.port
  )

}
