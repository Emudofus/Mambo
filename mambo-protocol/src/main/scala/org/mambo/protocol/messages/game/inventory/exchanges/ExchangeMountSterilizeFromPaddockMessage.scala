




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeMountSterilizeFromPaddockMessage extends MessageDeserializer {
  val messageId = 6056

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeMountSterilizeFromPaddockMessage.messageId

    val name: String
    val worldX: Short
    val worldY: Short
    val sterilizator: String

    def serialize(buf: Buffer) {
      buf.writeString(name)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeString(sterilizator)
    }

  }

  protected def create(name: String, worldX: Short, worldY: Short, sterilizator: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val name = buf.readString()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val sterilizator = buf.readString()

    create(name, worldX, worldY, sterilizator)
  }

}

object ExchangeMountSterilizeFromPaddockMessage extends ExchangeMountSterilizeFromPaddockMessage {
  case class MessageImpl(name: String, worldX: Short, worldY: Short, sterilizator: String) extends Message
  type Target = MessageImpl

  override def create(name: String, worldX: Short, worldY: Short, sterilizator: String) = MessageImpl(name, worldX, worldY, sterilizator)

  def apply(name: String, worldX: Short, worldY: Short, sterilizator: String) = create(name, worldX, worldY, sterilizator)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

