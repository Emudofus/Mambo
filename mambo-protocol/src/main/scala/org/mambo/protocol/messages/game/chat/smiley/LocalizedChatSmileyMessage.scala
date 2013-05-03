




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LocalizedChatSmileyMessage extends ChatSmileyMessage {
  override val messageId = 6185

  protected trait Message extends ChatSmileyMessage.Message with Serializable {
    override val messageId = LocalizedChatSmileyMessage.messageId

    val cellId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(cellId)
    }

  }

  protected def create(entityId: Int, smileyId: Byte, accountId: Int, cellId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val entityId = buf.readInt()
    val smileyId = buf.readByte()
    val accountId = buf.readInt()
    val cellId = buf.readShort()

    create(entityId, smileyId, accountId, cellId)
  }

}

object LocalizedChatSmileyMessage extends LocalizedChatSmileyMessage {
  case class MessageImpl(entityId: Int, smileyId: Byte, accountId: Int, cellId: Short) extends Message
  type Target = MessageImpl

  override def create(entityId: Int, smileyId: Byte, accountId: Int, cellId: Short) = MessageImpl(entityId, smileyId, accountId, cellId)

  def apply(entityId: Int, smileyId: Byte, accountId: Int, cellId: Short) = create(entityId, smileyId, accountId, cellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

