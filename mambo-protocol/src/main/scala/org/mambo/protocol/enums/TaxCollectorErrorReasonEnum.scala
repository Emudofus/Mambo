



















// Generated on 05/02/2013 20:27:17
// Scala version by Blackrush
package org.mambo.protocol.enums

import org.mambo.protocol.Enumeration

object TaxCollectorErrorReasonEnum extends Enumeration {
  val taxCollectorErrorUnknown = Value(0, "taxCollectorErrorUnknown")
  val taxCollectorNotFound = Value(1, "taxCollectorNotFound")
  val taxCollectorNotOwned = Value(2, "taxCollectorNotOwned")
  val taxCollectorNoRights = Value(3, "taxCollectorNoRights")
  val taxCollectorMaxReached = Value(4, "taxCollectorMaxReached")
  val taxCollectorAlreadyOne = Value(5, "taxCollectorAlreadyOne")
  val taxCollectorCantHireYet = Value(6, "taxCollectorCantHireYet")
  val taxCollectorCantHireHere = Value(7, "taxCollectorCantHireHere")
  val taxCollectorNotEnoughKamas = Value(8, "taxCollectorNotEnoughKamas")
}


