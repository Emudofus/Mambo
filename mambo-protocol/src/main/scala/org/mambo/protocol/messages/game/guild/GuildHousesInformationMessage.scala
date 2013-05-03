




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildHousesInformationMessage extends MessageDeserializer {
  val messageId = 5919

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildHousesInformationMessage.messageId

    val housesInformations: Seq[HouseInformationsForGuild.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(housesInformations.length)
      for (entry <- housesInformations) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(housesInformations: Seq[HouseInformationsForGuild.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val housesInformations = {
      val builder = collection.immutable.Seq.newBuilder[HouseInformationsForGuild.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += HouseInformationsForGuild.deserialize(buf)
      }
      builder.result()
    }

    create(housesInformations)
  }

}

object GuildHousesInformationMessage extends GuildHousesInformationMessage {
  case class MessageImpl(housesInformations: Seq[HouseInformationsForGuild.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(housesInformations: Seq[HouseInformationsForGuild.TypeImpl]) = MessageImpl(housesInformations)

  def apply(housesInformations: Seq[HouseInformationsForGuild.TypeImpl]) = create(housesInformations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

