package velet5.emklatz.http

import akka.http.scaladsl.server.Route

trait Controller {

  def route: Route

}
