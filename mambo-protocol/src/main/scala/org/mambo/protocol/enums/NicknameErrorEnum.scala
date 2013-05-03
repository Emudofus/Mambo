



















// Generated on 05/02/2013 20:27:17
// Scala version by Blackrush
package org.mambo.protocol.enums

import org.mambo.protocol.Enumeration

object NicknameErrorEnum extends Enumeration {
  val alreadyUsed = Value(1, "alreadyUsed")
  val sameAsLogin = Value(2, "sameAsLogin")
  val tooSimilarToLogin = Value(3, "tooSimilarToLogin")
  val invalidNick = Value(4, "invalidNick")
  val unknownNickError = Value(99, "unknownNickError")
}


