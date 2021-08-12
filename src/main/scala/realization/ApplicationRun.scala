package realization

import realization.drawing.{DrawingProcess, UIMaker}

import scala.swing.{MainFrame, SimpleSwingApplication}

trait ApplicationRun extends SimpleSwingApplication with DrawingProcess {

  override def top = new MainFrame {
    contents = new UIMaker
    resizable = false
  }

}
