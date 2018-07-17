import models._
import scala.annotation.tailrec

object GameLogic {

  val input = scala.io.StdIn

  def computerMove(): GameChoice = {
    val rnd = scala.util.Random.nextInt(5)
    rnd match {
      case 0 => Rock
      case 1 => Paper
      case 2 => Scissors
      case 3 => Lizard
      case 4 => Spock
    }
  }

  def singleGame(): Unit = {
    beginGame()
    playAgain()
  }

  def seriesOfGames(): Unit = {
    println("Would you like to play best of 3, 5 or 7")
    val best_of_choice = input.readInt()
    best_of_choice match {
      case 3 => for (i <- 1 to 3) if (Outcomes.won_matches <= 2 && Outcomes.lost_matches <= 2) {
        beginGame()
      }
      case 5 => for (i <- 1 to 5) if (Outcomes.won_matches <= 3 && Outcomes.lost_matches <= 3) {
        beginGame()
      }
      case 7 => for (i <- 1 to 7) if (Outcomes.won_matches <= 4 && Outcomes.lost_matches <= 4) {
        beginGame()
      }
    }
  }

  def gameMode(): Unit = {
    println("Welcome to Rock, Paper, Scissors, Lizard, Spock.\nWould you like to play a single match or a series?")
    if (input.readLine().contains("single")) {
      singleGame()
    } else {
      seriesOfGames()
    }
    Outcomes.printMatchResults()
    playAgain()
  }

  @tailrec
  def beginGame(): Unit = {
    println("\nPlease make a selection: Rock, Paper, Scissors, Lizard or Spock.")
    val user_input = input.readLine().toLowerCase.capitalize
    GameChoice(user_input) match {
      case Some(userChoice) =>
        val compChoice = computerMove()
        println(s"You have chosen $userChoice.\nThe computer has chosen $compChoice.")
        val decision = userChoice.vs(compChoice)
        decision match {
          case Draw => Outcomes.draw(); singleGame()
          case _ => Outcomes.handleResult(decision)
        }
      case None => beginGame()
    }
  }

  def playAgain(): Unit = {
    print("\nWould you like to play again?\n")
    val replay_choice = input.readLine().toLowerCase
    if (replay_choice == "yes") {
      Outcomes.won_matches = 0
      Outcomes.lost_matches = 0
      Outcomes.tied_matches = 0
      gameMode()
    } else {
      println("\nGoodbye, thanks for playing.")
    }
  }

  def main(args: Array[String]): Unit = {
    gameMode()
  }
}