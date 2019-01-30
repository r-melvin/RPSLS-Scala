package models

object ComputerMove {

  def apply(): Move = {
    val rnd: Int = scala.util.Random.nextInt(5)
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

