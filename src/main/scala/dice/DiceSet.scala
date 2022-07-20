package dice

import collection.mutable

class DiceSet(val set: mutable.Map[Dice, Int] = mutable.Map[Dice, Int]()):

  def add(dice: Dice, count: Int): DiceSet =
    set(dice) = set.getOrElse(dice, 0) + count
    this

  def roll(): Roll =
    val roll = new Roll()
    for (dice, count) <- set do roll.add(dice.rollN(count))
    roll
