package velet5.emklatz.http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.{Directives, Route}
import akka.stream.ActorMaterializer
import cats.syntax.option.catsSyntaxOptionId
import org.slf4j.LoggerFactory

import scala.concurrent.{ExecutionContext, Future}

class Endpoint(
  controllers: Seq[Controller],
  interface: String,
  port: Int
)(
  implicit executionContext: ExecutionContext,
  actorSystem: ActorSystem,
  actorMaterializer: ActorMaterializer
) extends Directives {

  def start(): Unit = {
    if (bindingFuture.isEmpty) {
      bindingFuture = Http().bindAndHandle(route, "0.0.0.0", port).some
    }
  }

  def stop(): Unit = {
    bindingFuture.foreach(
      _.flatMap(_.unbind())
        .onComplete(_ => {
          log.info("Endpoint is terminating")
        })
    )
  }

  // under the hood

  private val route: Route = pathPrefix("api" / "v1") {
    controllers.map(_.route).reduce(_ ~ _)
  }

  private val log = LoggerFactory.getLogger(getClass)

  @volatile
  private var bindingFuture: Option[Future[Http.ServerBinding]] = None

}
