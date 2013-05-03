




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismFightStateUpdateMessage extends MessageDeserializer {
  val messageId = 6040

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismFightStateUpdateMessage.messageId

    val state: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(state)
    }

  }

  protected def create(state: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val state = buf.readByte()

    create(state)
  }

}

object PrismFightStateUpdateMessage extends PrismFightStateUpdateMessage {
  case class MessageImpl(state: Byte) extends Message
  type Target = MessageImpl

  override def create(state: Byte) = MessageImpl(state)

  def apply(state: Byte) = create(state)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

