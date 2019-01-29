import constants.GameText._
import logic.Logic._
import models._

import scala.io.StdIn._

object Interaction extends App {

  def getUserMove: Move = {
    UserMove(readLine)
  }

  def initialiseGame() = {
    println(initialMsg)
    println(requestNameMsg)
    val userName: String = readLine
    println(selectionMsg + gameModeOptions)
    val gameModeChoice = gameMode(readLine)
    println(selectionMsg + moveChoiceMsg)
    playMode(gameModeChoice, getUserMove, userName)
  }

  initialiseGame()

}
