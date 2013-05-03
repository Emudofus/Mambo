




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectGroundAddedMessage extends MessageDeserializer {
  val messageId = 3017

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectGroundAddedMessage.messageId

    val cellId: Short
    val objectGID: Short

    def serialize(buf: Buffer) {
      buf.writeShort(cellId)
      buf.writeShort(objectGID)
    }

  }

  protected def create(cellId: Short, objectGID: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cellId = buf.readShort()
    val objectGID = buf.readShort()

    create(cellId, objectGID)
  }

}

object ObjectGroundAddedMessage extends ObjectGroundAddedMessage {
  case class MessageImpl(cellId: Short, objectGID: Short) extends Message
  type Target = MessageImpl

  override def create(cellId: Short, objectGID: Short) = MessageImpl(cellId, objectGID)

  def apply(cellId: Short, objectGID: Short) = create(cellId, objectGID)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

