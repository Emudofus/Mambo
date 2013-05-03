




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeMountTakenFromPaddockMessage extends MessageDeserializer {
  val messageId = 5994

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeMountTakenFromPaddockMessage.messageId

    val name: String
    val worldX: Short
    val worldY: Short
    val ownername: String

    def serialize(buf: Buffer) {
      buf.writeString(name)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeString(ownername)
    }

  }

  protected def create(name: String, worldX: Short, worldY: Short, ownername: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val name = buf.readString()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val ownername = buf.readString()

    create(name, worldX, worldY, ownername)
  }

}

object ExchangeMountTakenFromPaddockMessage extends ExchangeMountTakenFromPaddockMessage {
  case class MessageImpl(name: String, worldX: Short, worldY: Short, ownername: String) extends Message
  type Target = MessageImpl

  override def create(name: String, worldX: Short, worldY: Short, ownername: String) = MessageImpl(name, worldX, worldY, ownername)

  def apply(name: String, worldX: Short, worldY: Short, ownername: String) = create(name, worldX, worldY, ownername)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

