




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectSetPositionMessage extends MessageDeserializer {
  val messageId = 3021

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectSetPositionMessage.messageId

    val objectUID: Int
    val position: UByte
    val quantity: Int

    def serialize(buf: Buffer) {
      buf.writeInt(objectUID)
      buf.writeUByte(position)
      buf.writeInt(quantity)
    }

  }

  protected def create(objectUID: Int, position: UByte, quantity: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
    val position = buf.readUByte()
    val quantity = buf.readInt()

    create(objectUID, position, quantity)
  }

}

object ObjectSetPositionMessage extends ObjectSetPositionMessage {
  case class MessageImpl(objectUID: Int, position: UByte, quantity: Int) extends Message
  type Target = MessageImpl

  override def create(objectUID: Int, position: UByte, quantity: Int) = MessageImpl(objectUID, position, quantity)

  def apply(objectUID: Int, position: UByte, quantity: Int) = create(objectUID, position, quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

