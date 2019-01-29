package models

import org.scalatest.FlatSpec

class MovesSpec extends FlatSpec {

  "Rock vs Paper" should
    "Lose" in {
    assert(Rock.vs(Paper) equals Lose)
  }

  "Rock vs Rock" should
    "Draw" in {
    assert(Rock.vs(Rock) equals Draw)
  }

  "Rock vs Scissors" should
    "Win" in {
    assert(Rock.vs(Scissors) equals Win)
  }

  "Rock vs Lizard" should
    "Win" in {
    assert(Rock.vs(Lizard) equals Win)
  }

  "Rock vs Spock" should
    "Lose" in {
    assert(Rock.vs(Spock) equals Lose)
  }

  "Rock vs Illegal" should
    "Forfeit" in {
    assert(Rock.vs(Illegal) equals Forfeit)
  }

  "Paper vs Paper" should
    "Draw" in {
    assert(Paper.vs(Paper) equals Draw)
  }

  "Paper vs Rock" should
    "Win" in {
    assert(Paper.vs(Rock) equals Win)
  }

  "Paper vs Scissors" should
    "Lose" in {
    assert(Paper.vs(Scissors) equals Lose)
  }

  "Paper vs Lizard" should
    "Lose" in {
    assert(Paper.vs(Lizard) equals Lose)
  }

  "Paper vs Spock" should
    "Win" in {
    assert(Paper.vs(Spock) equals Win)
  }

  "Paper vs Illegal" should
    "Forfeit" in {
    assert(Rock.vs(Illegal) equals Forfeit)
  }

  "Scissors vs Paper" should
    "Win" in {
    assert(Scissors.vs(Paper) equals Win)
  }

  "Scissors vs Rock" should
    "Lose" in {
    assert(Scissors.vs(Rock) equals Lose)
  }

  "Scissors vs Scissors" should
    "Draw" in {
    assert(Scissors.vs(Scissors) equals Draw)
  }

  "Scissors vs Lizard" should
    "Win" in {
    assert(Scissors.vs(Lizard) equals Win)
  }

  "Scissors vs Spock" should
    "Lose" in {
    assert(Scissors.vs(Spock) equals Lose)
  }

  "Scissors vs Illegal" should
    "Forfeit" in {
    assert(Scissors.vs(Illegal) equals Forfeit)
  }

  "Lizard vs Paper" should
    "Win" in {
    assert(Lizard.vs(Paper) equals Win)
  }

  "Lizard vs Rock" should
    "Lose" in {
    assert(Lizard.vs(Rock) equals Lose)
  }

  "Lizard vs Scissors" should
    "Lose" in {
    assert(Lizard.vs(Scissors) equals Lose)
  }

  "Lizard vs Lizard" should
    "Draw" in {
    assert(Lizard.vs(Lizard) equals Draw)
  }

  "Lizard vs Spock" should
    "Win" in {
    assert(Lizard.vs(Spock) equals Win)
  }

  "Lizard vs Illegal" should
    "Forfeit" in {
    assert(Lizard.vs(Illegal) equals Forfeit)
  }

  "Spock vs Paper" should
    "Lose" in {
    assert(Spock.vs(Paper) equals Lose)
  }

  "Spock vs Rock" should
    "Win" in {
    assert(Spock.vs(Rock) equals Win)
  }

  "Spock vs Scissors" should
    "Win" in {
    assert(Spock.vs(Scissors) equals Win)
  }

  "Spock vs Lizard" should
    "Lose" in {
    assert(Spock.vs(Lizard) equals Lose)
  }

  "Spock vs Spock" should
    "Draw" in {
    assert(Spock.vs(Spock) equals Draw)
  }

  "Spock vs Illegal" should
    "Forfeit" in {
    assert(Spock.vs(Illegal) equals Forfeit)
  }

  "Illegal vs Illegal" should
    "Forfeit" in {
    assert(Illegal.vs(Illegal) equals Forfeit)
  }

}
