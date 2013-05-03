




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectFeedMessage extends MessageDeserializer {
  val messageId = 6290

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectFeedMessage.messageId

    val objectUID: Int
    val foodUID: Int
    val foodQuantity: Short

    def serialize(buf: Buffer) {
      buf.writeInt(objectUID)
      buf.writeInt(foodUID)
      buf.writeShort(foodQuantity)
    }

  }

  protected def create(objectUID: Int, foodUID: Int, foodQuantity: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
    val foodUID = buf.readInt()
    val foodQuantity = buf.readShort()

    create(objectUID, foodUID, foodQuantity)
  }

}

object ObjectFeedMessage extends ObjectFeedMessage {
  case class MessageImpl(objectUID: Int, foodUID: Int, foodQuantity: Short) extends Message
  type Target = MessageImpl

  override def create(objectUID: Int, foodUID: Int, foodQuantity: Short) = MessageImpl(objectUID, foodUID, foodQuantity)

  def apply(objectUID: Int, foodUID: Int, foodQuantity: Short) = create(objectUID, foodUID, foodQuantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

