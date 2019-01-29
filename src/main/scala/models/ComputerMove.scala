package models

object ComputerMove {
  val rnd: Int = scala.util.Random.nextInt(5)

  def apply(rnd: Int = 2): Move = {
    rnd match {
      case 0 => Rock
      case 1 => Paper
      case 2 => Scissors
      case 3 => Lizard
      case 4 => Spock
      case _ => Illegal
    }
  }
}

