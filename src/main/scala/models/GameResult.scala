package models

sealed trait GameResult

case object Draw extends GameResult

case object Win extends GameResult

case object Lose extends GameResult

object GameScore {

  var wonMatches = 0
  var lostMatches = 0
  var tiedMatches = 0

  def handleResult(gameResult: GameResult): Unit = gameResult match {
    case Draw =>
      println("\nYou have tied this match.\nReplay the match.\n")
      tiedMatches += 1
    case Win =>
      println("\nYou have won this match")
      wonMatches += 1
    case Lose =>
      println("You have lost this match")
      lostMatches += 1
  }

  def printMatchResults(): Unit = {
    println(s"\nYou have won $wonMatches matches in this series")
    println(s"You have lost $lostMatches matches in this series")
    println(s"You have tied $tiedMatches matches in this series")
  }
}