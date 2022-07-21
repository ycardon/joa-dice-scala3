package dice

import scala.collection.mutable

/** a helper to produce string representation of a map */
extension[K] (map: mutable.Map[K, Int]) def toStringHelper: String =
  map
    .map((k, v) => s"$v $k")
    .mkString(" | ")
  match
    case "" => "<nothing>"
    case s => s
