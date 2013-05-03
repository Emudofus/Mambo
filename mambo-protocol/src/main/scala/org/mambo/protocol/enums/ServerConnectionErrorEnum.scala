



















// Generated on 05/02/2013 20:27:17
// Scala version by Blackrush
package org.mambo.protocol.enums

import org.mambo.protocol.Enumeration

object ServerConnectionErrorEnum extends Enumeration {
  val serverConnectionErrorDueToStatus = Value(0, "serverConnectionErrorDueToStatus")
  val serverConnectionErrorNoReason = Value(1, "serverConnectionErrorNoReason")
  val serverConnectionErrorAccountRestricted = Value(2, "serverConnectionErrorAccountRestricted")
  val serverConnectionErrorCommunityRestricted = Value(3, "serverConnectionErrorCommunityRestricted")
  val serverConnectionErrorLocationRestricted = Value(4, "serverConnectionErrorLocationRestricted")
  val serverConnectionErrorSubscribersOnly = Value(5, "serverConnectionErrorSubscribersOnly")
  val serverConnectionErrorRegularPlayersOnly = Value(6, "serverConnectionErrorRegularPlayersOnly")
}


