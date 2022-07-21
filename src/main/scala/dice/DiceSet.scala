package dice

import collection.mutable

/** a set of dice to be rolled */
class DiceSet extends mutable.HashMap[Dice, Int] :

  def add(dice: Dice, count: Int): DiceSet =
    this.put(dice, this.getOrElse(dice, 0) + count)
    this

  def roll(): Roll =
    val roll = Roll()
    for (dice, count) <- this do roll.add(dice.rollN(count))
    roll

  // functional (not that cool) version
  // this.foldLeft(Roll())((r, keyValue) => r.add(keyValue._1.rollN(keyValue._2)))

  override def toString: String = this.toStringHelper
