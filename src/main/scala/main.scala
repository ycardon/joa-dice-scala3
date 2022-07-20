import dice._
import parser._

/** resolve an attack vs. defense */
def resolveAttack(attack: Roll, defense: Roll): Roll =
  val result = attack.clone

  // apply defense shields on the attack
  var shieldCount = defense.faces.getOrElse(Face.Shield, 0)
  shieldCount = result.cancel(Face.Kill, shieldCount)
  shieldCount = result.cancel(Face.Disrupt, shieldCount)
  shieldCount = result.cancel(Face.Push, shieldCount)
  
  // remove unrelevant faces from the attack
  attack.faces.remove(Face.Shield)
  attack.faces.remove(Face.Blank)

  result

/** cancel Roll face by an amount of shield, return remaining amount */
extension (roll: Roll) def cancel(face: Face, shieldCount: Int): Int =
  3


@main
def main(): Unit = {
  val s = "2B W - 3R"
  println(s)

  val (attackDiceSet, defenceDiceSet, isDefence) = s.parseJoA()
  val attack = attackDiceSet.roll()
  val attackClone = attack.clone
  attack.add(attack)
  println("attack x2: %s".format(attack))
  println("attack   : %s".format(attackClone))


  println(Face.Kill)
  println(Dice.RedDice.rollN(4))
  println(Dice.RedDice)
  println(attackDiceSet)


}