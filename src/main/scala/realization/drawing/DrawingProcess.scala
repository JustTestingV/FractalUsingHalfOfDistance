package realization.drawing

import figures.{Figure, PointCoords}
import realization.AppConfig
import syntax._

import java.awt.Color
import scala.annotation.tailrec

private[realization] trait DrawingProcess {

  import AppConfig.config._

  private[realization] val pixels: Array[Array[Color]] = Array.ofDim[Color](screenWidthPix, screenHeightPix).emptyScreen

  def drawFigure(figure: Figure): Unit = {
    pixels.clear

    figure.tops.foreach(pixels.setRed)
    val firstPoint = figure.chooseRandomTop(0)

    @tailrec
    def loop(oldPoint: PointCoords)(lastTopInd: Int = 0, currentStep: Int = 0, stepCount: Int = pointsCount): PointCoords = {
      val nextTopPoint = figure.chooseRandomTop(lastTopInd)
      val pointToColor = PointCoords(((nextTopPoint.x + oldPoint.x) / 2).toInt, ((nextTopPoint.y + oldPoint.y) / 2).toInt)
      pixels.setWhite(pointToColor)
      if (currentStep < stepCount) loop(pointToColor)(figure.tops.indexOf(nextTopPoint), currentStep + 1)
      else pointToColor
    }

    loop(firstPoint)()
  }


}
