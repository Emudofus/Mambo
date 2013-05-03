




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TitleLostMessage extends MessageDeserializer {
  val messageId = 6371

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TitleLostMessage.messageId

    val titleId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(titleId)
    }

  }

  protected def create(titleId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val titleId = buf.readShort()

    create(titleId)
  }

}

object TitleLostMessage extends TitleLostMessage {
  case class MessageImpl(titleId: Short) extends Message
  type Target = MessageImpl

  override def create(titleId: Short) = MessageImpl(titleId)

  def apply(titleId: Short) = create(titleId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

