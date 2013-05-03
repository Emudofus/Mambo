




















// Generated on 05/03/2013 10:34:38
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameContextCreateMessage extends MessageDeserializer {
  val messageId = 200

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameContextCreateMessage.messageId

    val context: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(context)
    }

  }

  protected def create(context: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val context = buf.readByte()

    create(context)
  }

}

object GameContextCreateMessage extends GameContextCreateMessage {
  case class MessageImpl(context: Byte) extends Message
  type Target = MessageImpl

  override def create(context: Byte) = MessageImpl(context)

  def apply(context: Byte) = create(context)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

