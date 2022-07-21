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

  override def toString: String = this.toStringHelper
