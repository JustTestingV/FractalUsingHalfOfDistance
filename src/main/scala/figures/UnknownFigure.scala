package figures

import Math.{sin, cos, PI}

case class UnknownFigure(sideCount: Int, screenWidth: Int, screenHeight: Int) extends Figure {
  private def calculateTops(n: Int, screenHeight: Int, screenWidth: Int): Vector[PointCoords] = {
    val center: PointCoords = PointCoords(screenWidth / 2, screenHeight / 2)
    val r = if (center.x > center.y) (screenHeight * 0.9) / 2 else (screenWidth * 0.9) / 2
    (for {
      i <- 0 until n
      x = r * cos(2 * PI * i / n)
      y = r * sin(2 * PI * i / n)
      rotate = math.toRadians(-90)
    } yield
      PointCoords((center.x + x * cos(rotate) - y * sin(rotate)).toInt, (center.y + x * sin(rotate) + y * cos(rotate)).toInt)
      ).toVector
  }

  val tops = calculateTops(sideCount, screenHeight, screenWidth)
}
