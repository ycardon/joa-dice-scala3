package dice

import scala.collection.mutable

/** the result of dice rolls */
class Roll(val faces: mutable.Map[Face, Int] = mutable.SortedMap[Face, Int]()):

  def add(face: Face, count: Int = 1): Roll =
    faces(face) = faces.getOrElse(face, 0) + count
    this

  def add(roll: Roll): Roll =
    for (face, count) <- roll.faces do add(face, count)
    this

  override def clone: Roll = new Roll(this.faces.clone())

  override def toString: String = faces.toStringHelper