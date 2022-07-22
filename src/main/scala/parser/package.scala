package parser

import dice.*
import dice.Dice.*

extension (s: String)

  /** parse a string in the form of "2R B - 3W" */
  def parseJoA(): (DiceSet, DiceSet, Boolean) =
    val attack    = DiceSet()
    val defence   = DiceSet()
    var isDefense = false

    if s != "" then
      for word <- s.split(' ') do
        if "-/".contains(word) then isDefense = true
        else
          word.last.parseDice() match
            case Some(dice) =>
              val count = word.init.parseInt()
              if !isDefense then attack.add(dice, count)
              else defence.add(dice, count)
            case None =>

    (attack, defence, isDefense)

  /** parse an int value or return 1 */
  def parseInt(): Int =
    try s.toInt
    catch case _: Exception => 1

extension (c: Char)
  /** parse a Dice value */
  def parseDice(): Option[Dice] = c.toUpper match
    case 'B' => Some(BlackDice)
    case 'R' => Some(RedDice)
    case 'Y' => Some(YellowDice)
    case 'W' => Some(WhiteDice)
    case 'G' => Some(GiganticDice)
    case 'D' => Some(DoomDice)
    case _   => None
