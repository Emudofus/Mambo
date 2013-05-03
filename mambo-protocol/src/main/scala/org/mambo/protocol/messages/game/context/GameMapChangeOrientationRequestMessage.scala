




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameMapChangeOrientationRequestMessage extends MessageDeserializer {
  val messageId = 945

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameMapChangeOrientationRequestMessage.messageId

    val direction: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(direction)
    }

  }

  protected def create(direction: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val direction = buf.readByte()

    create(direction)
  }

}

object GameMapChangeOrientationRequestMessage extends GameMapChangeOrientationRequestMessage {
  case class MessageImpl(direction: Byte) extends Message
  type Target = MessageImpl

  override def create(direction: Byte) = MessageImpl(direction)

  def apply(direction: Byte) = create(direction)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

