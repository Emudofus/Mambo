




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeWeightMessage extends MessageDeserializer {
  val messageId = 5793

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeWeightMessage.messageId

    val currentWeight: Int
    val maxWeight: Int

    def serialize(buf: Buffer) {
      buf.writeInt(currentWeight)
      buf.writeInt(maxWeight)
    }

  }

  protected def create(currentWeight: Int, maxWeight: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val currentWeight = buf.readInt()
    val maxWeight = buf.readInt()

    create(currentWeight, maxWeight)
  }

}

object ExchangeWeightMessage extends ExchangeWeightMessage {
  case class MessageImpl(currentWeight: Int, maxWeight: Int) extends Message
  type Target = MessageImpl

  override def create(currentWeight: Int, maxWeight: Int) = MessageImpl(currentWeight, maxWeight)

  def apply(currentWeight: Int, maxWeight: Int) = create(currentWeight, maxWeight)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

