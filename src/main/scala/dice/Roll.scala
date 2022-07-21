package dice

import scala.collection.mutable

/** the result of dice rolls */
class Roll extends mutable.HashMap[Face, Int] :

  def add(face: Face, count: Int = 1): Roll =
    this.put(face, this.getOrElse(face, 0) + count)
    this

  def add(roll: Roll): Roll =
    for (face, count) <- roll do add(face, count)
    this

  override def clone: Roll = new Roll().addAll(this)

  override def toString: String = this.toStringHelper