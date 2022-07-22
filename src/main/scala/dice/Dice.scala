package dice

import scala.util.Random
import dice.Face.*

enum Dice(val faces: Seq[Face]):
  case BlackDice    extends Dice(List(Kill, Disrupt, Disrupt, Shield, Shield, Shield))
  case RedDice      extends Dice(List(Kill, Kill, Disrupt, Disrupt, Push, Shield))
  case YellowDice   extends Dice(List(Disrupt, Push, Push, Shield, Blank, Blank))
  case WhiteDice    extends Dice(List(Disrupt, Disrupt, Push, Shield, Shield, Blank))
  case GiganticDice extends Dice(List(Kill, Disrupt, Disrupt, Push, Trample, Trample))
  case DoomDice     extends Dice(List(Disrupt, Death, Death, Rally, Rally, DelayedRally))

  def roll(): Face = Random.shuffle(faces).head

  def rollN(n: Int): Roll =
    if n > 0
    then rollN(n - 1).add(roll())
    else Roll()
