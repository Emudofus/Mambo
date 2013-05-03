




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait EmotePlayMassiveMessage extends EmotePlayAbstractMessage {
  override val messageId = 5691

  protected trait Message extends EmotePlayAbstractMessage.Message with Serializable {
    override val messageId = EmotePlayMassiveMessage.messageId

    val actorIds: Seq[Int]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(actorIds.length)
      for (entry <- actorIds) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(emoteId: Byte, emoteStartTime: Double, actorIds: Seq[Int]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val emoteId = buf.readByte()
    val emoteStartTime = buf.readDouble()
    val actorIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(emoteId, emoteStartTime, actorIds)
  }

}

object EmotePlayMassiveMessage extends EmotePlayMassiveMessage {
  case class MessageImpl(emoteId: Byte, emoteStartTime: Double, actorIds: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(emoteId: Byte, emoteStartTime: Double, actorIds: Seq[Int]) = MessageImpl(emoteId, emoteStartTime, actorIds)

  def apply(emoteId: Byte, emoteStartTime: Double, actorIds: Seq[Int]) = create(emoteId, emoteStartTime, actorIds)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

