package models

import org.scalatest.FlatSpec

class UserMoveSpec extends FlatSpec {

  "user enters 'rock'" should
    "return Rock" in {
    assert(UserMove("rock") equals Rock)
  }

  "user enters 'paper'" should
    "return Paper" in {
    assert(UserMove("paper") equals Paper)
  }

  "user enters 'scissors'" should
    "return Scissors" in {
    assert(UserMove("scissors") equals Scissors)
  }

  "user enters 'lizard'" should
    "return Lizard" in {
    assert(UserMove("lizard") equals Lizard)
  }

  "user enters 'spock'" should
    "return Spock" in {
    assert(UserMove("spock") equals Spock)
  }

  "user enters 'rtytuyku'" should
    "return Illegal" in {
    assert(UserMove("rtytuyku") equals Illegal)
  }

}
