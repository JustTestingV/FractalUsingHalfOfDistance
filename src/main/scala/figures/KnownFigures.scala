package figures

object KnownFigures {

  import realization.AppConfig.config.{screenWidthPix, screenHeightPix}

  val triangle = Triangle(screenWidthPix, screenHeightPix)
  val rectangle = Rectangle(screenWidthPix, screenHeightPix)

}
