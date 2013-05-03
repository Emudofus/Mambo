




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PaddockToSellFilterMessage extends MessageDeserializer {
  val messageId = 6161

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PaddockToSellFilterMessage.messageId

    val areaId: Int
    val atLeastNbMount: Byte
    val atLeastNbMachine: Byte
    val maxPrice: Int

    def serialize(buf: Buffer) {
      buf.writeInt(areaId)
      buf.writeByte(atLeastNbMount)
      buf.writeByte(atLeastNbMachine)
      buf.writeInt(maxPrice)
    }

  }

  protected def create(areaId: Int, atLeastNbMount: Byte, atLeastNbMachine: Byte, maxPrice: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val areaId = buf.readInt()
    val atLeastNbMount = buf.readByte()
    val atLeastNbMachine = buf.readByte()
    val maxPrice = buf.readInt()

    create(areaId, atLeastNbMount, atLeastNbMachine, maxPrice)
  }

}

object PaddockToSellFilterMessage extends PaddockToSellFilterMessage {
  case class MessageImpl(areaId: Int, atLeastNbMount: Byte, atLeastNbMachine: Byte, maxPrice: Int) extends Message
  type Target = MessageImpl

  override def create(areaId: Int, atLeastNbMount: Byte, atLeastNbMachine: Byte, maxPrice: Int) = MessageImpl(areaId, atLeastNbMount, atLeastNbMachine, maxPrice)

  def apply(areaId: Int, atLeastNbMount: Byte, atLeastNbMachine: Byte, maxPrice: Int) = create(areaId, atLeastNbMount, atLeastNbMachine, maxPrice)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

