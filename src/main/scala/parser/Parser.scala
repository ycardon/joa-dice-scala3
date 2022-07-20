package parser

import dice.DiceSet

extension (s: String) def parseJoA(): ParsingResult =
  val attack = new DiceSet()
  val defence = new DiceSet()
  var isDef = false

  for word <- s.split(' ') do
    if "-/".contains(word) then
      isDef = true
    else
      word.init

  ParsingResult(attack, defence, isDef)


case class ParsingResult(attack: DiceSet, defence: DiceSet, isDef: Boolean)

