package models

object UserMove {
  def apply(str: String): Move = str.toLowerCase match {
    case "rock" => Rock
    case "scissors" => Scissors
    case "paper" => Paper
    case "lizard" => Lizard
    case "spock" => Spock
    case _ => Illegal
  }
}
