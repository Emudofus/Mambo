




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryWeightMessage extends MessageDeserializer {
  val messageId = 3009

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryWeightMessage.messageId

    val weight: Int
    val weightMax: Int

    def serialize(buf: Buffer) {
      buf.writeInt(weight)
      buf.writeInt(weightMax)
    }

  }

  protected def create(weight: Int, weightMax: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val weight = buf.readInt()
    val weightMax = buf.readInt()

    create(weight, weightMax)
  }

}

object InventoryWeightMessage extends InventoryWeightMessage {
  case class MessageImpl(weight: Int, weightMax: Int) extends Message
  type Target = MessageImpl

  override def create(weight: Int, weightMax: Int) = MessageImpl(weight, weightMax)

  def apply(weight: Int, weightMax: Int) = create(weight, weightMax)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

