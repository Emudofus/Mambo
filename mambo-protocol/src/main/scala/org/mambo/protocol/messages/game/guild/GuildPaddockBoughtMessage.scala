




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildPaddockBoughtMessage extends MessageDeserializer {
  val messageId = 5952

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildPaddockBoughtMessage.messageId

    val paddockInfo: PaddockContentInformations.TypeImpl

    def serialize(buf: Buffer) {
      paddockInfo.serialize(buf)
    }

  }

  protected def create(paddockInfo: PaddockContentInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val paddockInfo = PaddockContentInformations.deserialize(buf)

    create(paddockInfo)
  }

}

object GuildPaddockBoughtMessage extends GuildPaddockBoughtMessage {
  case class MessageImpl(paddockInfo: PaddockContentInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(paddockInfo: PaddockContentInformations.TypeImpl) = MessageImpl(paddockInfo)

  def apply(paddockInfo: PaddockContentInformations.TypeImpl) = create(paddockInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

