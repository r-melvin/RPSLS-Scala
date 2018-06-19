import models._

import scala.annotation.tailrec

/**
  * Created by richardmelvin on 14/06/18.
  */
object GameLogic {

  val input = scala.io.StdIn
  var tied_matches = 0
  var won_matches = 0
  var lost_matches = 0

  def draw(): Unit = {
    println("\nYou have tied this match.\nReplay the match.\n")
    beginGame()
    tied_matches += 1
  }

  def win(): Unit = {
    println("\nYou have won this match")
    won_matches += 1
  }

  def lose(): Unit = {
    println("\nYou have lost this match")
    lost_matches += 1
  }

  def handleResult(result: GameResult): Unit = result match {
    case Draw => draw()
    case Win => win()
    case Lose => lose()
  }

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

  def printMatchResults(): Unit = {
    println(s"\nYou have won $won_matches matches in this series")
    println(s"You have lost $lost_matches matches in this series")
    println(s"You have tied $tied_matches matches in this series")
  }

  def gameMode(): Unit = {
    println("Welcome to Rock, Paper, Scissors, Lizard, Spock.\nWould you like to play a single match or a series?")
    if (input.readLine().contains("single")) {
      beginGame()
      playAgain()
    } else {
      println("Would you like to play best of 3, 5 or 7")
      val best_of_choice = input.readInt()
      best_of_choice match {
        case 3 => for (i <- 1 to 3) if (won_matches <= 2 && lost_matches <= 2) {
          beginGame()
        }
        case 5 => for (i <- 1 to 5) if (won_matches <= 3 && lost_matches <= 3) {
          beginGame()
        }
        case 7 => for (i <- 1 to 7) if (won_matches <= 4 && lost_matches <= 4) {
          beginGame()
        }
      }
      printMatchResults()
      playAgain()
    }
  }


  @tailrec
  def beginGame(): Unit = {
    println("\nPlease make a selection: Rock, Paper, Scissors, Lizard or Spock.")
    val user_input = input.readLine().toLowerCase.capitalize
    GameChoice(user_input) match {
      case Some(userChoice) =>
        val compChoice = computerMove()
        println(s"You have chosen $userChoice.\nThe computer has chosen $compChoice.")
        handleResult(userChoice.vs(compChoice))
      case None => beginGame()
    }
  }

  def playAgain(): Unit = {
    print("\nWould you like to play again?\n")
    val replay_choice = input.readLine().toLowerCase
    if (replay_choice == "yes") {
      won_matches = 0
      lost_matches = 0
      tied_matches = 0
      gameMode()
    } else {
      println("\nGoodbye, thanks for playing.")
    }
  }

  def main(args: Array[String]): Unit = {
    gameMode()
  }
}
