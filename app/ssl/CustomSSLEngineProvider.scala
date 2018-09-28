package ssl

import javax.net.ssl.SSLEngine
import play.core.ApplicationProvider
import play.core.server.ServerConfig
import play.core.server.ssl.DefaultSSLEngineProvider
import play.server.api.SSLEngineProvider

class CustomSSLEngineProvider(serverConfig: ServerConfig, appProvider: ApplicationProvider) extends SSLEngineProvider {

  private val underlying = new DefaultSSLEngineProvider(serverConfig, appProvider)

  override def createSSLEngine(): SSLEngine = {

    val engine = underlying.createSSLEngine()
    engine.setUseClientMode(false)
    engine.setNeedClientAuth(true)
    engine.setWantClientAuth(true)

    println(s"""
               | This is my provider:
               | ${engine.getClass}
               | need client auth: ${engine.getNeedClientAuth}
               | want client auth: ${engine.getWantClientAuth}
               | -----------------------------------------
              """.stripMargin)

    engine
  }
}
