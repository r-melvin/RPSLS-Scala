package models

sealed trait GameResult

case object Draw extends GameResult
case object Win extends GameResult
case object Lose extends GameResult




