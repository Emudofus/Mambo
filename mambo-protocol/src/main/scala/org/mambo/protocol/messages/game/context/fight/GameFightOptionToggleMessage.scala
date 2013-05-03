




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightOptionToggleMessage extends MessageDeserializer {
  val messageId = 707

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightOptionToggleMessage.messageId

    val option: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(option)
    }

  }

  protected def create(option: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val option = buf.readByte()

    create(option)
  }

}

object GameFightOptionToggleMessage extends GameFightOptionToggleMessage {
  case class MessageImpl(option: Byte) extends Message
  type Target = MessageImpl

  override def create(option: Byte) = MessageImpl(option)

  def apply(option: Byte) = create(option)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

