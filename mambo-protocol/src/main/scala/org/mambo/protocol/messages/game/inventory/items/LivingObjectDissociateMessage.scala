




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LivingObjectDissociateMessage extends MessageDeserializer {
  val messageId = 5723

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LivingObjectDissociateMessage.messageId

    val livingUID: Int
    val livingPosition: UByte

    def serialize(buf: Buffer) {
      buf.writeInt(livingUID)
      buf.writeUByte(livingPosition)
    }

  }

  protected def create(livingUID: Int, livingPosition: UByte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val livingUID = buf.readInt()
    val livingPosition = buf.readUByte()

    create(livingUID, livingPosition)
  }

}

object LivingObjectDissociateMessage extends LivingObjectDissociateMessage {
  case class MessageImpl(livingUID: Int, livingPosition: UByte) extends Message
  type Target = MessageImpl

  override def create(livingUID: Int, livingPosition: UByte) = MessageImpl(livingUID, livingPosition)

  def apply(livingUID: Int, livingPosition: UByte) = create(livingUID, livingPosition)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

