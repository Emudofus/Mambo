




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionAcknowledgementMessage extends MessageDeserializer {
  val messageId = 957

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameActionAcknowledgementMessage.messageId

    val valid: Boolean
    val actionId: Byte

    def serialize(buf: Buffer) {
      buf.writeBoolean(valid)
      buf.writeByte(actionId)
    }

  }

  protected def create(valid: Boolean, actionId: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val valid = buf.readBoolean()
    val actionId = buf.readByte()

    create(valid, actionId)
  }

}

object GameActionAcknowledgementMessage extends GameActionAcknowledgementMessage {
  case class MessageImpl(valid: Boolean, actionId: Byte) extends Message
  type Target = MessageImpl

  override def create(valid: Boolean, actionId: Byte) = MessageImpl(valid, actionId)

  def apply(valid: Boolean, actionId: Byte) = create(valid, actionId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

