




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LivingObjectChangeSkinRequestMessage extends MessageDeserializer {
  val messageId = 5725

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LivingObjectChangeSkinRequestMessage.messageId

    val livingUID: Int
    val livingPosition: UByte
    val skinId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(livingUID)
      buf.writeUByte(livingPosition)
      buf.writeInt(skinId)
    }

  }

  protected def create(livingUID: Int, livingPosition: UByte, skinId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val livingUID = buf.readInt()
    val livingPosition = buf.readUByte()
    val skinId = buf.readInt()

    create(livingUID, livingPosition, skinId)
  }

}

object LivingObjectChangeSkinRequestMessage extends LivingObjectChangeSkinRequestMessage {
  case class MessageImpl(livingUID: Int, livingPosition: UByte, skinId: Int) extends Message
  type Target = MessageImpl

  override def create(livingUID: Int, livingPosition: UByte, skinId: Int) = MessageImpl(livingUID, livingPosition, skinId)

  def apply(livingUID: Int, livingPosition: UByte, skinId: Int) = create(livingUID, livingPosition, skinId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

