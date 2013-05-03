




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicAckMessage extends MessageDeserializer {
  val messageId = 6362

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicAckMessage.messageId

    val seq: Int
    val lastPacketId: Short

    def serialize(buf: Buffer) {
      buf.writeInt(seq)
      buf.writeShort(lastPacketId)
    }

  }

  protected def create(seq: Int, lastPacketId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val seq = buf.readInt()
    val lastPacketId = buf.readShort()

    create(seq, lastPacketId)
  }

}

object BasicAckMessage extends BasicAckMessage {
  case class MessageImpl(seq: Int, lastPacketId: Short) extends Message
  type Target = MessageImpl

  override def create(seq: Int, lastPacketId: Short) = MessageImpl(seq, lastPacketId)

  def apply(seq: Int, lastPacketId: Short) = create(seq, lastPacketId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

