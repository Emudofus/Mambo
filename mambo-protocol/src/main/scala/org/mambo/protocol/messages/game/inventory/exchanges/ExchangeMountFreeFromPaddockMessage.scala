




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeMountFreeFromPaddockMessage extends MessageDeserializer {
  val messageId = 6055

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeMountFreeFromPaddockMessage.messageId

    val name: String
    val worldX: Short
    val worldY: Short
    val liberator: String

    def serialize(buf: Buffer) {
      buf.writeString(name)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeString(liberator)
    }

  }

  protected def create(name: String, worldX: Short, worldY: Short, liberator: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val name = buf.readString()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val liberator = buf.readString()

    create(name, worldX, worldY, liberator)
  }

}

object ExchangeMountFreeFromPaddockMessage extends ExchangeMountFreeFromPaddockMessage {
  case class MessageImpl(name: String, worldX: Short, worldY: Short, liberator: String) extends Message
  type Target = MessageImpl

  override def create(name: String, worldX: Short, worldY: Short, liberator: String) = MessageImpl(name, worldX, worldY, liberator)

  def apply(name: String, worldX: Short, worldY: Short, liberator: String) = create(name, worldX, worldY, liberator)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

