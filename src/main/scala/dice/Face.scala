package dice

/** the faces of a die */
enum Face(val id: Int) extends Ordered[Face]:
  override def compare(that: Face): Int = this.id - that.id

  case Kill         extends Face(0)
  case Disrupt      extends Face(1)
  case Push         extends Face(2)
  case Shield       extends Face(3)
  case Blank        extends Face(4)
  case Trample      extends Face(5)
  case Death        extends Face(6)
  case Rally        extends Face(7)
  case DelayedRally extends Face(8)
