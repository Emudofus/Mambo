




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ShortcutBarSwapErrorMessage extends MessageDeserializer {
  val messageId = 6226

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ShortcutBarSwapErrorMessage.messageId

    val error: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(error)
    }

  }

  protected def create(error: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val error = buf.readByte()

    create(error)
  }

}

object ShortcutBarSwapErrorMessage extends ShortcutBarSwapErrorMessage {
  case class MessageImpl(error: Byte) extends Message
  type Target = MessageImpl

  override def create(error: Byte) = MessageImpl(error)

  def apply(error: Byte) = create(error)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

