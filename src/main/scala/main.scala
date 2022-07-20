import dice._
import parser._

/** resolve an attack : apply defense shields on the attack then remove irrelevant faces from the attack */
def resolveAttack(attack: Roll, defense: Roll): Roll =
  val result = attack.clone
  var shieldCount = defense.faces.getOrElse(Face.Shield, 0)
  for face <- List(Face.Kill, Face.Disrupt, Face.Push) do
    shieldCount = result.cancel(face, shieldCount)
  for face <- Vector(Face.Shield, Face.Blank) do
    result.faces.remove(face)
  result

/** cancel Roll face by an amount of shield, return remaining amount */
extension (roll: Roll) def cancel(face: Face, shieldCount: Int): Int =
  roll.faces.get(face) match
    case Some(faceCount) =>
      if faceCount > shieldCount then
        roll.faces(face) = faceCount - shieldCount
        0
      else
        roll.faces.remove(face)
        shieldCount - faceCount
    case None =>
      shieldCount

@main
def main(): Unit =
  val input = "20B 10R - 30W"

  val (attackSet, defenceSet, isDefence) = input.parseJoA()
  val attack = attackSet.roll()
  if !isDefence then
    println("attack : %s".format(attack))
  else
    val defence = defenceSet.roll()
    val result = resolveAttack(attack, defence)
    println("attack  : %s".format(attack))
    println("defence : %s".format(defence))
    println("result  : %s".format(result))
