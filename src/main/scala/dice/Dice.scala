package dice

import scala.util.Random

enum Dice(val faces: Vector[Face]):
  case BlackDice extends Dice(Vector(Face.Kill, Face.Disrupt, Face.Disrupt, Face.Shield, Face.Shield, Face.Shield))
  case RedDice extends Dice(Vector(Face.Kill, Face.Kill, Face.Disrupt, Face.Disrupt, Face.Push, Face.Shield))
  case YellowDice extends Dice(Vector(Face.Disrupt, Face.Push, Face.Push, Face.Shield, Face.Blank, Face.Blank))
  case WhiteDice extends Dice(Vector(Face.Disrupt, Face.Disrupt, Face.Push, Face.Shield, Face.Shield, Face.Blank))
  case GiganticDice extends Dice(Vector(Face.Kill, Face.Disrupt, Face.Disrupt, Face.Push, Face.Trample, Face.Trample))
  case DoomDice extends Dice(Vector(Face.Disrupt, Face.Death, Face.Death, Face.Rally, Face.Rally, Face.DelayedRally))

  def roll(): Face =
    Random.shuffle(faces).head

  def rollN(n: Int): Roll =
    if n > 0 then
      rollN(n - 1).add(roll())
    else new Roll()
