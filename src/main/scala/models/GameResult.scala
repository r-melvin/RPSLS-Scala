package models

sealed trait GameResult

case object Draw extends GameResult

case object Win extends GameResult

case object Lose extends GameResult

def draw (): Unit = {
  println ("\nYou have tied this match.\nReplay the match.\n")
  beginGame ()
  tied_matches += 1
}

  def win (): Unit = {
  println ("\nYou have won this match")
  won_matches += 1
}

  def lose (): Unit = {
  println ("\nYou have lost this match")
  lost_matches += 1
}

  def handleResult (result: GameResult): Unit = result match {
  case Draw => draw ()
  case Win => win ()
  case Lose => lose ()
}
