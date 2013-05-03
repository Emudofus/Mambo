



















// Generated on 05/02/2013 20:27:17
// Scala version by Blackrush
package org.mambo.protocol.enums

import org.mambo.protocol.Enumeration

object ExchangeErrorEnum extends Enumeration {
  val requestImpossible = Value(1, "requestImpossible")
  val requestCharacterOccupied = Value(2, "requestCharacterOccupied")
  val requestCharacterJobNotEquiped = Value(3, "requestCharacterJobNotEquiped")
  val requestCharacterToolTooFar = Value(4, "requestCharacterToolTooFar")
  val requestCharacterOverloaded = Value(5, "requestCharacterOverloaded")
  val requestCharacterNotSuscriber = Value(6, "requestCharacterNotSuscriber")
  val requestCharacterRestricted = Value(7, "requestCharacterRestricted")
  val buyError = Value(8, "buyError")
  val sellError = Value(9, "sellError")
  val mountPaddockError = Value(10, "mountPaddockError")
  val bidSearchError = Value(11, "bidSearchError")
}


