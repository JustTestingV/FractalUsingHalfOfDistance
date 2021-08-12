package realization

import com.typesafe.config.ConfigFactory
import pureconfig.{ConfigReader, ConfigSource}

case class AppConfig(
                      screenWidthPix: Int,
                      screenHeightPix: Int,
                      pointsCount: Int,
                    )

object AppConfig {
  private implicit val configReader: ConfigReader[AppConfig] = pureconfig.generic.semiauto.deriveReader

  val config: AppConfig = ConfigSource.fromConfig(ConfigFactory.load()).loadOrThrow[AppConfig]
}
