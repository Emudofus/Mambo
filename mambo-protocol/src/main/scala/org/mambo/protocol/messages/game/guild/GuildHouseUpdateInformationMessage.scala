




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildHouseUpdateInformationMessage extends MessageDeserializer {
  val messageId = 6181

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildHouseUpdateInformationMessage.messageId

    val housesInformations: HouseInformationsForGuild.TypeImpl

    def serialize(buf: Buffer) {
      housesInformations.serialize(buf)
    }

  }

  protected def create(housesInformations: HouseInformationsForGuild.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val housesInformations = HouseInformationsForGuild.deserialize(buf)

    create(housesInformations)
  }

}

object GuildHouseUpdateInformationMessage extends GuildHouseUpdateInformationMessage {
  case class MessageImpl(housesInformations: HouseInformationsForGuild.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(housesInformations: HouseInformationsForGuild.TypeImpl) = MessageImpl(housesInformations)

  def apply(housesInformations: HouseInformationsForGuild.TypeImpl) = create(housesInformations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

