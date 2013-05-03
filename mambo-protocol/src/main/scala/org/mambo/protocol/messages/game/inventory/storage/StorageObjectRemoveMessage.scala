




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StorageObjectRemoveMessage extends MessageDeserializer {
  val messageId = 5648

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StorageObjectRemoveMessage.messageId

    val objectUID: Int

    def serialize(buf: Buffer) {
      buf.writeInt(objectUID)
    }

  }

  protected def create(objectUID: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()

    create(objectUID)
  }

}

object StorageObjectRemoveMessage extends StorageObjectRemoveMessage {
  case class MessageImpl(objectUID: Int) extends Message
  type Target = MessageImpl

  override def create(objectUID: Int) = MessageImpl(objectUID)

  def apply(objectUID: Int) = create(objectUID)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

