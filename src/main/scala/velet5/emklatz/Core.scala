package velet5.emklatz

import velet5.emklatz.config.Configuration

trait Core {

  lazy val configuration: Configuration = pureconfig.loadConfigOrThrow[Configuration]

}
