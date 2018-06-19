package models

sealed trait GameChoice {
  def vs(choice: GameChoice): GameResult
}

object GameChoice {
  def apply(str: String): Option[GameChoice] = str match {
    case "Rock" => Some(Rock)
    case "Scissors" => Some(Scissors)
    case "Paper" => Some(Paper)
    case "Lizard" => Some(Lizard)
    case "Spock" => Some(Spock)
    case _ => None
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
