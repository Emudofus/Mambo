




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait EmotePlayMessage extends EmotePlayAbstractMessage {
  override val messageId = 5683

  protected trait Message extends EmotePlayAbstractMessage.Message with Serializable {
    override val messageId = EmotePlayMessage.messageId

    val actorId: Int
    val accountId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(actorId)
      buf.writeInt(accountId)
    }

  }

  protected def create(emoteId: Byte, emoteStartTime: Double, actorId: Int, accountId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val emoteId = buf.readByte()
    val emoteStartTime = buf.readDouble()
    val actorId = buf.readInt()
    val accountId = buf.readInt()

    create(emoteId, emoteStartTime, actorId, accountId)
  }

}

object EmotePlayMessage extends EmotePlayMessage {
  case class MessageImpl(emoteId: Byte, emoteStartTime: Double, actorId: Int, accountId: Int) extends Message
  type Target = MessageImpl

  override def create(emoteId: Byte, emoteStartTime: Double, actorId: Int, accountId: Int) = MessageImpl(emoteId, emoteStartTime, actorId, accountId)

  def apply(emoteId: Byte, emoteStartTime: Double, actorId: Int, accountId: Int) = create(emoteId, emoteStartTime, actorId, accountId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

