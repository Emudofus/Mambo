




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LivingObjectMessageMessage extends MessageDeserializer {
  val messageId = 6065

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LivingObjectMessageMessage.messageId

    val msgId: Short
    val timeStamp: UInt
    val owner: String
    val objectGenericId: UInt

    def serialize(buf: Buffer) {
      buf.writeShort(msgId)
      buf.writeUInt(timeStamp)
      buf.writeString(owner)
      buf.writeUInt(objectGenericId)
    }

  }

  protected def create(msgId: Short, timeStamp: UInt, owner: String, objectGenericId: UInt): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val msgId = buf.readShort()
    val timeStamp = buf.readUInt()
    val owner = buf.readString()
    val objectGenericId = buf.readUInt()

    create(msgId, timeStamp, owner, objectGenericId)
  }

}

object LivingObjectMessageMessage extends LivingObjectMessageMessage {
  case class MessageImpl(msgId: Short, timeStamp: UInt, owner: String, objectGenericId: UInt) extends Message
  type Target = MessageImpl

  override def create(msgId: Short, timeStamp: UInt, owner: String, objectGenericId: UInt) = MessageImpl(msgId, timeStamp, owner, objectGenericId)

  def apply(msgId: Short, timeStamp: UInt, owner: String, objectGenericId: UInt) = create(msgId, timeStamp, owner, objectGenericId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

