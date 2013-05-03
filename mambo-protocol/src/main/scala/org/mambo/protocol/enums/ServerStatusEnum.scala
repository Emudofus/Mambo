



















// Generated on 05/02/2013 20:27:17
// Scala version by Blackrush
package org.mambo.protocol.enums

import org.mambo.protocol.Enumeration

object ServerStatusEnum extends Enumeration {
  val statusUnknown = Value(0, "statusUnknown")
  val offline = Value(1, "offline")
  val starting = Value(2, "starting")
  val online = Value(3, "online")
  val nojoin = Value(4, "nojoin")
  val saving = Value(5, "saving")
  val stoping = Value(6, "stoping")
  val full = Value(7, "full")
}


