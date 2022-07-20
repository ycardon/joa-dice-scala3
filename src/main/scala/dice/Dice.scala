package dice

import scala.util.Random
import dice.Face._

enum Dice(val faces: Vector[Face]):
  case BlackDice extends Dice(Vector(Kill, Disrupt, Disrupt, Shield, Shield, Shield))
  case RedDice extends Dice(Vector(Kill, Kill, Disrupt, Disrupt, Push, Shield))
  case YellowDice extends Dice(Vector(Disrupt, Push, Push, Shield, Blank, Blank))
  case WhiteDice extends Dice(Vector(Disrupt, Disrupt, Push, Shield, Shield, Blank))
  case GiganticDice extends Dice(Vector(Kill, Disrupt, Disrupt, Push, Trample, Trample))
  case DoomDice extends Dice(Vector(Disrupt, Death, Death, Rally, Rally, DelayedRally))

  def roll(): Face =
    Random.shuffle(faces).head

  def rollN(n: Int): Roll =
    if n > 0
    then rollN(n - 1).add(roll())
    else new Roll()
