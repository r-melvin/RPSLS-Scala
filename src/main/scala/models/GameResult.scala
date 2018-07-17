package models

sealed trait GameResult

case object Draw extends GameResult

case object Win extends GameResult

case object Lose extends GameResult

  object Outcomes {
    var tied_matches = 0
    var won_matches = 0
    var lost_matches = 0

    def draw(): Unit = {
      println("\nYou have tied this match.\nReplay the match.\n")
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
    def printMatchResults(): Unit = {
      println(s"\nYou have won $won_matches matches in this series")
      println(s"You have lost $lost_matches matches in this series")
      println(s"You have tied $tied_matches matches in this series")
    }
  }