import dice._
import parser._

//def resolveAttack(attack: Roll, defense: Roll): Roll


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