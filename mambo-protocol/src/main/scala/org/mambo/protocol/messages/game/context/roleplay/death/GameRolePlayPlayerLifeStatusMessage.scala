




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayPlayerLifeStatusMessage extends MessageDeserializer {
  val messageId = 5996

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayPlayerLifeStatusMessage.messageId

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

object GameRolePlayPlayerLifeStatusMessage extends GameRolePlayPlayerLifeStatusMessage {
  case class MessageImpl(state: Byte) extends Message
  type Target = MessageImpl

  override def create(state: Byte) = MessageImpl(state)

  def apply(state: Byte) = create(state)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

