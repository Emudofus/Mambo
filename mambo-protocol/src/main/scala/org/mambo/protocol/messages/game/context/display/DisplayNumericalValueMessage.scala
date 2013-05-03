




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DisplayNumericalValueMessage extends MessageDeserializer {
  val messageId = 5808

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DisplayNumericalValueMessage.messageId

    val entityId: Int
    val value: Int
    val theType: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(entityId)
      buf.writeInt(value)
      buf.writeByte(theType)
    }

  }

  protected def create(entityId: Int, value: Int, theType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val entityId = buf.readInt()
    val value = buf.readInt()
    val theType = buf.readByte()

    create(entityId, value, theType)
  }

}

object DisplayNumericalValueMessage extends DisplayNumericalValueMessage {
  case class MessageImpl(entityId: Int, value: Int, theType: Byte) extends Message
  type Target = MessageImpl

  override def create(entityId: Int, value: Int, theType: Byte) = MessageImpl(entityId, value, theType)

  def apply(entityId: Int, value: Int, theType: Byte) = create(entityId, value, theType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

