package dice

import scala.collection.mutable

class Roll(val faces: mutable.Map[Face, Int] = mutable.Map[Face, Int]()):

  def add(face: Face, count: Int = 1): Roll =
    faces(face) = faces.getOrElse(face, 0) + count
    this

  def add(roll: Roll): Roll =
    for (face, count) <- roll.faces do add(face, count)
    this

  override def clone(): Roll =
    new Roll(this.faces.clone())