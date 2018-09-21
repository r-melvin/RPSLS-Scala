package models


sealed trait GameResult

case object Draw extends GameResult

case object Win extends GameResult

case object Lose extends GameResult

case object Forfeit extends GameResult


case class Metrics(matchesWon: Int, matchesTied: Int, matchesLost: Int)


sealed trait GameChoice {
  def vs(choice: GameChoice): GameResult
}

object UserMove {
  def apply(str: String): GameChoice = str match {
    case "rock" => Rock
    case "scissors" => Scissors
    case "paper" => Paper
    case "lizard" => Lizard
    case "spock" => Spock
    case _ => Invalid
  }
}

object ComputerMove {
  def moveSelection(): GameChoice = {
    val rnd = 0 //scala.util.Random.nextInt(5)
    rnd match {
      case 0 => Rock
      case 1 => Paper
      case 2 => Scissors
      case 3 => Lizard
      case 4 => Spock
      case _ => Invalid
    }
  }
}

case object Rock extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Scissors | Lizard => Win
    case Rock => Draw
    case Paper | Spock => Lose
    case _ => Forfeit
  }
}

case object Paper extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Rock | Spock => Win
    case Paper => Draw
    case Scissors | Lizard => Lose
    case _ => Forfeit
  }
}

case object Scissors extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Paper | Lizard => Win
    case Scissors => Draw
    case Rock | Spock => Lose
    case _ => Forfeit
  }
}

case object Lizard extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Paper | Spock => Win
    case Lizard => Draw
    case Scissors | Rock => Lose
    case _ => Forfeit
  }
}

case object Spock extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Rock | Scissors => Win
    case Spock => Draw
    case Lizard | Paper => Lose
    case _ => Forfeit
  }
}

case object Invalid extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case _ => Forfeit
  }
}
