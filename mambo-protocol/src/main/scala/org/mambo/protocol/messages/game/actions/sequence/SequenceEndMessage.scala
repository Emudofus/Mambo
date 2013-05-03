




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SequenceEndMessage extends MessageDeserializer {
  val messageId = 956

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SequenceEndMessage.messageId

    val actionId: Short
    val authorId: Int
    val sequenceType: Byte

    def serialize(buf: Buffer) {
      buf.writeShort(actionId)
      buf.writeInt(authorId)
      buf.writeByte(sequenceType)
    }

  }

  protected def create(actionId: Short, authorId: Int, sequenceType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val authorId = buf.readInt()
    val sequenceType = buf.readByte()

    create(actionId, authorId, sequenceType)
  }

}

object SequenceEndMessage extends SequenceEndMessage {
  case class MessageImpl(actionId: Short, authorId: Int, sequenceType: Byte) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, authorId: Int, sequenceType: Byte) = MessageImpl(actionId, authorId, sequenceType)

  def apply(actionId: Short, authorId: Int, sequenceType: Byte) = create(actionId, authorId, sequenceType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

