import models._
import scala.annotation.tailrec

object GameLogic {

  private val input = scala.io.StdIn

  def main(args: Array[String]): Unit = {
    gameMode()
  }

  def gameMode(): Unit = {
    println("Welcome to Rock, Paper, Scissors, Lizard, Spock.\nWould you like to play a single match or a series?")
    if (input.readLine().contains("single")) {
      singleGame()
    } else {
      seriesOfGames()
    }
    playAgain()
  }

  def singleGame(): Unit = {
    beginGame()
    playAgain()
  }

  @tailrec
  def seriesOfGames(): Unit = {
    println("Would you like to play best of 3, 5 or 7")
    val choice = input.readInt()
    choice match {
      case 3 => for (i <- 1 to 3) if (GameScore.wonMatches < 2 && GameScore.lostMatches < 2) {
        beginGame()
      }
      case 5 => for (i <- 1 to 5) if (GameScore.wonMatches < 3 && GameScore.lostMatches < 3) {
        beginGame()
      }
      case 7 => for (i <- 1 to 7) if (GameScore.wonMatches < 4 && GameScore.lostMatches < 4) {
        beginGame()
      }
      case _ => println("Please make a valid selection.")
        seriesOfGames()
    }
  }

  @tailrec
  def beginGame(): Unit = {
    println("\nPlease make a selection: Rock, Paper, Scissors, Lizard or Spock.")
    val user_input = input.readLine().toLowerCase
    GameChoice(user_input) match {
      case Some(userChoice) =>
        val compChoice = ComputerMove.moveSelection()
        println(s"You have chosen $userChoice.\nThe computer has chosen $compChoice.")
        val decision = userChoice.vs(compChoice)
        decision match {
          case Draw => Draw; singleGame()
          case _ => GameScore.handleResult(decision)
        }
      case _ => beginGame()
    }
  }

  def playAgain(): Unit = {
    println("\nWould you like to play again? Yes or no?\n")
    val choice = input.readLine().toLowerCase
    if (choice == "yes") {
      GameScore.wonMatches = 0
      GameScore.lostMatches = 0
      GameScore.tiedMatches = 0
      gameMode()
    } else {
      println("\nGoodbye, thanks for playing.")
      System.exit(0)
    }
  }
}