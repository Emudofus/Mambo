



















// Generated on 05/02/2013 20:27:17
// Scala version by Blackrush
package org.mambo.protocol.enums

import org.mambo.protocol.Enumeration

object IdentificationFailureReasonEnum extends Enumeration {
  val badVersion = Value(1, "badVersion")
  val wrongCredentials = Value(2, "wrongCredentials")
  val banned = Value(3, "banned")
  val kicked = Value(4, "kicked")
  val inMaintenance = Value(5, "inMaintenance")
  val tooManyOnIp = Value(6, "tooManyOnIp")
  val timeOut = Value(7, "timeOut")
  val badIprange = Value(8, "badIprange")
  val credentialsReset = Value(9, "credentialsReset")
  val emailUnvalidated = Value(10, "emailUnvalidated")
  val serviceUnavailable = Value(53, "serviceUnavailable")
  val unknownAuthError = Value(99, "unknownAuthError")
  val spare = Value(100, "spare")
}


