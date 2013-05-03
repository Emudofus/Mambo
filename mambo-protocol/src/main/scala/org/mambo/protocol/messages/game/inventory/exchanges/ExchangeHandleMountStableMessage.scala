




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeHandleMountStableMessage extends MessageDeserializer {
  val messageId = 5965

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeHandleMountStableMessage.messageId

    val actionType: Byte
    val rideId: Int

    def serialize(buf: Buffer) {
      buf.writeByte(actionType)
      buf.writeInt(rideId)
    }

  }

  protected def create(actionType: Byte, rideId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val actionType = buf.readByte()
    val rideId = buf.readInt()

    create(actionType, rideId)
  }

}

object ExchangeHandleMountStableMessage extends ExchangeHandleMountStableMessage {
  case class MessageImpl(actionType: Byte, rideId: Int) extends Message
  type Target = MessageImpl

  override def create(actionType: Byte, rideId: Int) = MessageImpl(actionType, rideId)

  def apply(actionType: Byte, rideId: Int) = create(actionType, rideId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

