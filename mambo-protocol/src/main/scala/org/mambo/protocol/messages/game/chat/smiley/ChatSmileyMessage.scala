




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChatSmileyMessage extends MessageDeserializer {
  val messageId = 801

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChatSmileyMessage.messageId

    val entityId: Int
    val smileyId: Byte
    val accountId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(entityId)
      buf.writeByte(smileyId)
      buf.writeInt(accountId)
    }

  }

  protected def create(entityId: Int, smileyId: Byte, accountId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val entityId = buf.readInt()
    val smileyId = buf.readByte()
    val accountId = buf.readInt()

    create(entityId, smileyId, accountId)
  }

}

object ChatSmileyMessage extends ChatSmileyMessage {
  case class MessageImpl(entityId: Int, smileyId: Byte, accountId: Int) extends Message
  type Target = MessageImpl

  override def create(entityId: Int, smileyId: Byte, accountId: Int) = MessageImpl(entityId, smileyId, accountId)

  def apply(entityId: Int, smileyId: Byte, accountId: Int) = create(entityId, smileyId, accountId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

