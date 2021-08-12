package realization.drawing

import figures.KnownFigures._
import figures.UnknownFigure
import realization.AppConfig

import java.awt.{Color, Dimension, Graphics2D}
import scala.swing.event.{ButtonClicked, EditDone}
import scala.swing.{Button, FlowPanel, Font, TextField}

private[realization] class UIMaker extends FlowPanel with DrawingProcess {

  import AppConfig.config._

  preferredSize = new Dimension(screenWidthPix, screenHeightPix)

  private val standardFont = new Font("Times New Roman", java.awt.Font.PLAIN, 20)
  private val standardSize = new Dimension(120, 30)

  private val rectangleButton = new Button("Rectangle") {
    preferredSize = standardSize
    font = standardFont
  }
  private val triangleButton = new Button("Triangle") {
    preferredSize = standardSize
    font = standardFont

  }
  private val textField = new TextField(18) {
    font = standardFont
    text = "Enter side count"
  }

  listenTo(triangleButton, rectangleButton, textField)

  reactions += {
    case ButtonClicked(`rectangleButton`) =>
      drawFigure(rectangle)
      repaint()
    case ButtonClicked(`triangleButton`) =>
      drawFigure(triangle)
      repaint()
    case EditDone(`textField`) =>
      try {
        val sideCount = textField.text.toInt
        assert(sideCount > 1 && sideCount <= 100)
        val newFigure = UnknownFigure(sideCount, screenWidthPix, screenHeightPix)
        drawFigure(newFigure)
        repaint()
      }
      catch {
        case ex: Throwable =>
          println(ex)
          textField.text = "Enter full number from 2 to 100"
      }
  }

  override def paintComponent(g: Graphics2D): Unit = {
    for {
      x <- pixels.indices
      y <- pixels(x).indices
    } {
      pixels(x)(y) match {
        case c: Color => g.setColor(c)
      }
      g.fillRect(x, y, 1, 1)
    }
  }

  contents ++= Seq(triangleButton, rectangleButton, textField)
}
