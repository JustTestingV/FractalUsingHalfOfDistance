package figures

import scala.util.Random

trait Figure {
  val tops: Vector[PointCoords]

  private def candidatesToChoose(point: PointCoords): (PointCoords, PointCoords, PointCoords) = {
    val maxInd: Int = tops.size - 1
    val currentInd = tops.indexOf(point)
    currentInd match {
      case 0 => (tops(maxInd), point, tops(1))
      case ind if ind == maxInd => (tops(maxInd - 1), point, tops(0))
      case ind => (tops(ind - 1), point, tops(ind + 1))
    }
  }

  def chooseRandomTop(number: Int): PointCoords = {
    Random.nextInt(3) match {
      case 0 => tops.map(candidatesToChoose).lift(number).get._1
      case 1 => tops.map(candidatesToChoose).lift(number).get._2
      case 2 => tops.map(candidatesToChoose).lift(number).get._3
    }
  }
}
