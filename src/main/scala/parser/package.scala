package parser

import dice._
import dice.Dice._

/** parse a string in the form of "2R B - 3W" */
extension (s: String) def parseJoA(): (DiceSet, DiceSet, Boolean) =
  val attack = new DiceSet()
  val defence = new DiceSet()
  var isDefense = false

  for word <- s.split(' ') do
    if "-/".contains(word) then
      isDefense = true
    else
      word.last.parseDice() match
        case Some(dice) =>
          if !isDefense
          then attack.add(dice, word.init.parseInt())
          else defence.add(dice, word.init.parseInt())
        case None =>

  (attack, defence, isDefense)

/** parse an int value or return 1 */
extension (s: String) def parseInt(): Int =
  try s.toInt
  catch case _: Exception => 1

/** parse a Dice value */
extension (c: Char) def parseDice(): Option[Dice] = c.toUpper match
  case 'B' => Some(BlackDice)
  case 'R' => Some(RedDice)
  case 'Y' => Some(YellowDice)
  case 'W' => Some(WhiteDice)
  case 'G' => Some(GiganticDice)
  case 'D' => Some(DoomDice)
  case _ => None
