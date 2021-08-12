package figures

case class Rectangle(private val screenWidth: Int, private val screenHeight: Int) extends Figure {
  private val topLeftUp = PointCoords(screenWidth / 5, screenHeight / 5)
  private val topLeftDown = PointCoords(screenWidth / 5, screenHeight / 5 * 4)
  private val topRightUp = PointCoords(screenWidth / 5 * 4, screenHeight / 5)
  private val topRightDown = PointCoords(screenWidth / 5 * 4, screenHeight / 5 * 4)

  val tops: Vector[PointCoords] = Vector(topRightUp, topLeftUp, topLeftDown, topRightDown)
}
