package models

sealed trait Move {
  def vs(choice: Move): GameResult
}

case object Rock extends Move {
  def vs(choice: Move): GameResult = choice match {
    case Scissors | Lizard => Win
    case Rock => Draw
    case Paper | Spock => Lose
    case _ => Forfeit
  }
}

case object Paper extends Move {
  def vs(choice: Move): GameResult = choice match {
    case Rock | Spock => Win
    case Paper => Draw
    case Scissors | Lizard => Lose
    case _ => Forfeit
  }
}

case object Scissors extends Move {
  def vs(choice: Move): GameResult = choice match {
    case Paper | Lizard => Win
    case Scissors => Draw
    case Rock | Spock => Lose
    case _ => Forfeit
  }
}

case object Lizard extends Move {
  def vs(choice: Move): GameResult = choice match {
    case Paper | Spock => Win
    case Lizard => Draw
    case Scissors | Rock => Lose
    case _ => Forfeit
  }
}

case object Spock extends Move {
  def vs(choice: Move): GameResult = choice match {
    case Rock | Scissors => Win
    case Spock => Draw
    case Lizard | Paper => Lose
    case _ => Forfeit
  }
}

case object Illegal extends Move {
  def vs(choice: Move): GameResult = choice match {
    case _ => Forfeit
  }
}
