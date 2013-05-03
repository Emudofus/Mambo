




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TaxCollectorDialogQuestionBasicMessage extends MessageDeserializer {
  val messageId = 5619

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TaxCollectorDialogQuestionBasicMessage.messageId

    val guildInfo: BasicGuildInformations.TypeImpl

    def serialize(buf: Buffer) {
      guildInfo.serialize(buf)
    }

  }

  protected def create(guildInfo: BasicGuildInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guildInfo = BasicGuildInformations.deserialize(buf)

    create(guildInfo)
  }

}

object TaxCollectorDialogQuestionBasicMessage extends TaxCollectorDialogQuestionBasicMessage {
  case class MessageImpl(guildInfo: BasicGuildInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(guildInfo: BasicGuildInformations.TypeImpl) = MessageImpl(guildInfo)

  def apply(guildInfo: BasicGuildInformations.TypeImpl) = create(guildInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

