import models._
import scala.io.StdIn

object Game {

  val metrics = Metrics(0, 0, 0)

  private def gameLogic(userMove: GameChoice, computerMove: GameChoice): GameResult = {
    userMove.vs(computerMove)
  }

  def startGame(): GameResult = {
    println("\n\nPlease make a selection.")
    val computerMove = ComputerMove.moveSelection()
    val input = StdIn.readLine.toLowerCase
    println(s"You have chosen '${input.capitalize}'.\n\nYour opponent has chosen '$computerMove'")
    gameLogic(UserMove(input), computerMove)
  }

  def logResult(result: GameResult): Metrics = result match {
    case Win => println("\nYou have won this match.")
      metrics.copy(matchesWon = metrics.matchesWon + 1)
    case Lose => println("\nYour opponent has won this match.")
      metrics.copy(matchesLost = metrics.matchesLost + 1)
    case Draw => println("\nThe result is a tie, please play again.")
      metrics.copy(matchesTied = metrics.matchesTied + 1)
    case Forfeit => println("\nYou have entered an invalid selection and thus forfeited the game. The scores will be zeroed.")
      metrics
  }

  def printResult(metrics: Metrics): Unit = {
    println(s"\nThe current results of this series are:\n       ${metrics.matchesWon} matches won," +
      s"\n       ${metrics.matchesLost} matches lost,\n       ${metrics.matchesTied} matches tied.")
  }

  def replay(): Unit = {
    println("Would you like to play again?")
    val input = StdIn.readLine.toLowerCase
    if (input contains "y") {
      printResult(logResult(startGame()))
      replay()
    }
  }


  def chooseGameType(): Unit = {
    println("\nWould you like to play a single game or a series of games?\n\n Please type 'single' or 'series'.")
    val input = StdIn.readLine.toLowerCase
    if (input == "single") printResult(logResult(startGame()))
    else if (input == "series") printResult(logResult(playSeries()))
    else {
      println("Please make a valid selection.")
      chooseGameType()
    }
  }

  def main(args: Array[String]): Unit = {
    println("\nWelcome to Rock, Paper, Scissors, Lizard, Spock.")
    printResult(logResult(startGame()))
    replay()
  }

}
