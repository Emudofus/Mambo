



















// Generated on 05/02/2013 20:27:17
// Scala version by Blackrush
package org.mambo.protocol.enums

import org.mambo.protocol.Enumeration

object CharacterCreationResultEnum extends Enumeration {
  val ok = Value(0, "ok")
  val errNoReason = Value(1, "errNoReason")
  val errInvalidName = Value(2, "errInvalidName")
  val errNameAlreadyExists = Value(3, "errNameAlreadyExists")
  val errTooManyCharacters = Value(4, "errTooManyCharacters")
  val errNotAllowed = Value(5, "errNotAllowed")
  val errNewPlayerNotAllowed = Value(6, "errNewPlayerNotAllowed")
  val errRestricedZone = Value(7, "errRestricedZone")
}


