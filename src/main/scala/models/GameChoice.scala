package models

sealed trait GameChoice {
  def vs(choice: GameChoice): GameResult
}

object GameChoice {
  def apply(str: String): Option[GameChoice] = str match {
    case "rock" => Some(Rock)
    case "scissors" => Some(Scissors)
    case "paper" => Some(Paper)
    case "lizard" => Some(Lizard)
    case "spock" => Some(Spock)
    case _ => Some(Invalid)
  }
}

case object ComputerMove {
  def moveSelection(): GameChoice = {
    val rnd = scala.util.Random.nextInt(5)
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
    case _ => Lose
  }
}

case object Paper extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Rock | Spock => Win
    case Paper => Draw
    case _ => Lose
  }
}

case object Scissors extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Paper | Lizard => Win
    case Scissors => Draw
    case _ => Lose
  }
}

case object Lizard extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Paper | Spock => Win
    case Lizard => Draw
    case _ => Lose
  }
}

case object Spock extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case Rock | Scissors => Win
    case Spock => Draw
    case _ => Lose
  }
}

case object Invalid extends GameChoice {
  def vs(choice: GameChoice): GameResult = choice match {
    case _ => Lose
  }
}
