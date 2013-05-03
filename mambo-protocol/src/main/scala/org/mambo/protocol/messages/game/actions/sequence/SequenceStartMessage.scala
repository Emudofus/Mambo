




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SequenceStartMessage extends MessageDeserializer {
  val messageId = 955

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SequenceStartMessage.messageId

    val sequenceType: Byte
    val authorId: Int

    def serialize(buf: Buffer) {
      buf.writeByte(sequenceType)
      buf.writeInt(authorId)
    }

  }

  protected def create(sequenceType: Byte, authorId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val sequenceType = buf.readByte()
    val authorId = buf.readInt()

    create(sequenceType, authorId)
  }

}

object SequenceStartMessage extends SequenceStartMessage {
  case class MessageImpl(sequenceType: Byte, authorId: Int) extends Message
  type Target = MessageImpl

  override def create(sequenceType: Byte, authorId: Int) = MessageImpl(sequenceType, authorId)

  def apply(sequenceType: Byte, authorId: Int) = create(sequenceType, authorId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

