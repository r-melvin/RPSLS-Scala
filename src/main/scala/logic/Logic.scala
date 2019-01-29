package logic

import constants._
import models._

object Logic {

  def gameMode(input: String): GameMode = input match {
    case "single" | "single game" => SingleGame
    case "best of three" => BestOfThree
    case "best of five" => BestOfFive
    case "best of seven" => BestOfSeven
    case _ => throw new Exception("Invalid selection. Please restart the game.")
  }

  def playMode(mode: GameMode,userMove: Move, userName: String): GameResult = mode match {
      case SingleGame => beginGame(userMove, userName)
      //  TODO implement case BestOfThree => beginThreeGames()
      //  TODO implement case BestOfFive => beginFiveGames()
      //  TODO implement case BestOfSeven => beginSevenGames()
    }

  def beginThreeGames() = ???

  def beginFiveGames() = ???

  def beginSevenGames() = ???


  def beginGame(userMove: Move, userName: String): GameResult = {
    val compMove = ComputerMove()
    GameText.moveSelectionMsg(userMove, compMove, userName)
    userMove vs compMove
  }

  //TODO implement function to count wins, losses, draws

  // TODO implement replay functionality

}
