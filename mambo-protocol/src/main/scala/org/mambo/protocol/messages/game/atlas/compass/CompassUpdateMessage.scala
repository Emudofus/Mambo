




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CompassUpdateMessage extends MessageDeserializer {
  val messageId = 5591

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CompassUpdateMessage.messageId

    val theType: Byte
    val worldX: Short
    val worldY: Short

    def serialize(buf: Buffer) {
      buf.writeByte(theType)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
    }

  }

  protected def create(theType: Byte, worldX: Short, worldY: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theType = buf.readByte()
    val worldX = buf.readShort()
    val worldY = buf.readShort()

    create(theType, worldX, worldY)
  }

}

object CompassUpdateMessage extends CompassUpdateMessage {
  case class MessageImpl(theType: Byte, worldX: Short, worldY: Short) extends Message
  type Target = MessageImpl

  override def create(theType: Byte, worldX: Short, worldY: Short) = MessageImpl(theType, worldX, worldY)

  def apply(theType: Byte, worldX: Short, worldY: Short) = create(theType, worldX, worldY)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

