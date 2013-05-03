




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseGuildNoneMessage extends MessageDeserializer {
  val messageId = 5701

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseGuildNoneMessage.messageId

    val houseId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(houseId)
    }

  }

  protected def create(houseId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val houseId = buf.readShort()

    create(houseId)
  }

}

object HouseGuildNoneMessage extends HouseGuildNoneMessage {
  case class MessageImpl(houseId: Short) extends Message
  type Target = MessageImpl

  override def create(houseId: Short) = MessageImpl(houseId)

  def apply(houseId: Short) = create(houseId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

