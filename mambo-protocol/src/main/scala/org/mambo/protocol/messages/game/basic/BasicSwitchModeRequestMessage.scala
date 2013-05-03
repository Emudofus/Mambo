




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicSwitchModeRequestMessage extends MessageDeserializer {
  val messageId = 6101

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicSwitchModeRequestMessage.messageId

    val mode: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(mode)
    }

  }

  protected def create(mode: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mode = buf.readByte()

    create(mode)
  }

}

object BasicSwitchModeRequestMessage extends BasicSwitchModeRequestMessage {
  case class MessageImpl(mode: Byte) extends Message
  type Target = MessageImpl

  override def create(mode: Byte) = MessageImpl(mode)

  def apply(mode: Byte) = create(mode)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

