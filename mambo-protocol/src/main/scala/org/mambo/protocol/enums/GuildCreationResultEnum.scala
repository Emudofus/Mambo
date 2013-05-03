



















// Generated on 05/02/2013 20:27:17
// Scala version by Blackrush
package org.mambo.protocol.enums

import org.mambo.protocol.Enumeration

object GuildCreationResultEnum extends Enumeration {
  val guildCreateOk = Value(1, "guildCreateOk")
  val guildCreateErrorNameInvalid = Value(2, "guildCreateErrorNameInvalid")
  val guildCreateErrorAlreadyInGuild = Value(3, "guildCreateErrorAlreadyInGuild")
  val guildCreateErrorNameAlreadyExists = Value(4, "guildCreateErrorNameAlreadyExists")
  val guildCreateErrorEmblemAlreadyExists = Value(5, "guildCreateErrorEmblemAlreadyExists")
  val guildCreateErrorLeave = Value(6, "guildCreateErrorLeave")
  val guildCreateErrorCancel = Value(7, "guildCreateErrorCancel")
  val guildCreateErrorRequirementUnmet = Value(8, "guildCreateErrorRequirementUnmet")
  val guildCreateErrorEmblemInvalid = Value(9, "guildCreateErrorEmblemInvalid")
}


