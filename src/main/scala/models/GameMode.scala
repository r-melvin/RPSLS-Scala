package models

sealed trait GameMode

case object  SingleGame extends GameMode

sealed trait Series extends GameMode

case object BestOfThree extends Series

case object BestOfFive extends Series

case object BestOfSeven extends Series
