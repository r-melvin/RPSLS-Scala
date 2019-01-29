package models

import org.scalatest.FlatSpec

class ComputerMoveSpec extends FlatSpec {

  "computer" should
    "choose rock" in {
    assert(ComputerMove(rnd = 0) equals Rock)
  }

  "computer" should
    "choose paper" in {
    assert(ComputerMove(rnd = 1) equals Paper)
  }

  "computer" should
    "choose scissors" in {
    assert(ComputerMove(rnd = 2) equals Scissors)
  }

  "computer" should
    "choose lizard" in {
    assert(ComputerMove(rnd = 3) equals Lizard)
  }

  "computer" should
    "choose spock" in {
    assert(ComputerMove(rnd = 4) equals Spock)
  }

  "computer" should
    "choose illegal" in {
    assert(ComputerMove(rnd = 5) equals Illegal)
  }

}
