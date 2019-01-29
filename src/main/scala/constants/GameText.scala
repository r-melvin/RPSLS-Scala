package constants

import models.Move


object GameText {
  val initialMsg = "Welcome to this text version of Rock, Paper, Scissors, Lizard, Spock."
  val requestNameMsg = "What is your name?"
  val selectionMsg = "Please make a selection: "
  val gameModeOptions = "Single game, best of three, best of five or best of seven."
  val moveChoiceMsg = "Rock, Paper, Scissors, Lizard or Spock."
  val playAgainMsg = "Would you like to play another game?"
  val tiedGameMsg = "You have tied this game with the computer"

  def moveSelectionMsg(userMove: Move, compMove: Move, userName: String): Unit =
    println(s"$userName has chosen $userMove.\nThe computer has chosen $compMove.")

  def userVictoryMsg(userMove: Move, compMove: Move, userName: String): Unit =
    println(s"$userMove beats $compMove.\n$userName has won this hand.")

  def userLossMsg(userMove: Move, compMove: Move): Unit =
    println(s"$compMove beats $userMove.\nThe computer has won this hand.")

}
