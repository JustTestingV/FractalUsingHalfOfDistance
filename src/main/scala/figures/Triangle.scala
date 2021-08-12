package figures

case class Triangle(private val screenWidth: Int, private val screenHeight: Int) extends Figure {
  private val topUp = PointCoords(screenWidth / 2, screenHeight / 5)
  private val topLeft = PointCoords(screenWidth / 5, screenHeight / 5 * 4)
  private val topRight = PointCoords(screenWidth / 5 * 4, screenHeight / 5 * 4)

  val tops: Vector[PointCoords] = Vector(topUp, topRight, topLeft)
}
