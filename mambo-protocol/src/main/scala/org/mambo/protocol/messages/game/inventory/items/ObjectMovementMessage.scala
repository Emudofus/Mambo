




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectMovementMessage extends MessageDeserializer {
  val messageId = 3010

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectMovementMessage.messageId

    val objectUID: Int
    val position: UByte

    def serialize(buf: Buffer) {
      buf.writeInt(objectUID)
      buf.writeUByte(position)
    }

  }

  protected def create(objectUID: Int, position: UByte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
    val position = buf.readUByte()

    create(objectUID, position)
  }

}

object ObjectMovementMessage extends ObjectMovementMessage {
  case class MessageImpl(objectUID: Int, position: UByte) extends Message
  type Target = MessageImpl

  override def create(objectUID: Int, position: UByte) = MessageImpl(objectUID, position)

  def apply(objectUID: Int, position: UByte) = create(objectUID, position)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

