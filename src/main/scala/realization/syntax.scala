import figures.PointCoords

import java.awt.Color

package object syntax {

  implicit class DataConverter(pixels: Array[Array[Color]]) {
    def setColor(p: PointCoords)(c: Color): Unit = {
      pixels(p.x)(p.y) = c
    }

    def setBlack(p: PointCoords): Unit = pixels.setColor(p)(Color.BLACK)

    def setWhite(p: PointCoords): Unit = pixels.setColor(p)(Color.WHITE)

    def setRed(p: PointCoords): Unit = pixels.setColor(p)(Color.RED)
  }

  implicit class ClearPixels(pixels: Array[Array[Color]]) {
    def emptyScreen
    : Array[Array[Color]] = pixels.map(_.map(_ => Color.BLACK))

    def clear: Unit = for {
      i <- pixels.indices
      k <- pixels(0).indices
    } pixels.setBlack(PointCoords(i, k))
  }
}
