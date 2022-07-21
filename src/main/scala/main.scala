import dice._
import dice.Face._
import parser._

/** resolve an attack : apply defense shields on the attack then remove irrelevant faces from the attack */
def resolveAttack(attack: Roll, defense: Roll): Roll =
  val result = attack.clone()
  var shieldCount = defense.getOrElse(Shield, 0)

  for face <- Seq(Kill, Disrupt, Push) do
    shieldCount = result.cancel(face, shieldCount)
  for face <- Seq(Shield, Blank) do
    result.remove(face)

  result

/** cancel Roll face by an amount of shield, return remaining amount */
extension (roll: Roll) def cancel(face: Face, shieldCount: Int): Int =
  roll.get(face) match
    case Some(faceCount) =>
      if faceCount > shieldCount then
        roll(face) = faceCount - shieldCount
        0
      else
        roll.remove(face)
        shieldCount - faceCount
    case None =>
      shieldCount

/** parse a string and resolve the dice rolls */
def joa(input: String): Unit =
  val (attackSet, defenceSet, isDefence) = input.parseJoA()
  val attack = attackSet.roll()
  if !isDefence then
    println(s"attack : $attack")
  else
    val defence = defenceSet.roll()
    val result = resolveAttack(attack, defence)
    println(s"attack  : $attack")
    println(s"defence : $defence")
    println(s"result  : $result")

/** JVM entrypoint */
//@main
//def main(): Unit = joa("20R 10B - 30W")

/** entrypoint for ScalaNative */
def main(args: Array[String]): Unit = joa(args.mkString(" "))
