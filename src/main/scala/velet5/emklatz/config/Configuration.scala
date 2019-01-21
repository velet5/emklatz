package velet5.emklatz.config

case class Configuration(
  endpoint: EndpointProperties,
  googleOauth: GoogleOauthProperties
)

case class EndpointProperties(interface: String, port: Int)

// Should be there in case i'll lose "application.conf"
// "Emklatz OAuth Web Application"
// https://console.developers.google.com/apis/credentials?project=emklatz&folder&organizationId
case class GoogleOauthProperties(
  serviceUrl: String,
  clientId: String,
  clientSecret: String
)
