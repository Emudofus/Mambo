




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IgnoredDeleteResultMessage extends MessageDeserializer {
  val messageId = 5677

  protected trait Message extends BaseMessage with Serializable {
    val messageId = IgnoredDeleteResultMessage.messageId

    val success: Boolean
    val session: Boolean
    val name: String

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, success)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, session)
      buf.writeUByte(flag1.toShort)
      buf.writeString(name)
    }

  }

  protected def create(success: Boolean, session: Boolean, name: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val success = BooleanByteWrapper.getFlag(flag1, 0)
    val session = BooleanByteWrapper.getFlag(flag1, 1)
    val name = buf.readString()

    create(success, session, name)
  }

}

object IgnoredDeleteResultMessage extends IgnoredDeleteResultMessage {
  case class MessageImpl(success: Boolean, session: Boolean, name: String) extends Message
  type Target = MessageImpl

  override def create(success: Boolean, session: Boolean, name: String) = MessageImpl(success, session, name)

  def apply(success: Boolean, session: Boolean, name: String) = create(success, session, name)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

