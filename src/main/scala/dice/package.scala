package dice

import scala.collection.mutable

/** a helper to produce string representation of a map */
extension[K] (map: mutable.Map[K, Int]) def toStringHelper: String =
  val separator = " | "
  val builder = new mutable.StringBuilder()

  for (key, count) <- map do builder.append("%s%s %s".format(separator, count, key))

  if builder.length > separator.length then
    builder.substring(separator.length)
  else ""
