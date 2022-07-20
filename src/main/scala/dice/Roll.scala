package dice

import scala.collection.mutable

class Roll(val faces: mutable.Map[Face, Int] = mutable.Map[Face, Int]()):

  def add(face: Face, count: Int = 1): Roll =
    faces(face) = faces.getOrElse(face, 0) + count
    this

  def add(roll: Roll): Roll =
    for (face, count) <- roll.faces do add(face, count)
    this

  override def clone: Roll =
    new Roll(this.faces.clone())

  override def toString: String =
    val separator = " | "
    val builder = new mutable.StringBuilder()
    for (dice, count) <- faces do builder.append("%s%s %s".format(separator, count, dice))
    if builder.length > separator.length then
      builder.substring(separator.length)
    else ""