




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicSetAwayModeRequestMessage extends MessageDeserializer {
  val messageId = 5665

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicSetAwayModeRequestMessage.messageId

    val enable: Boolean
    val invisible: Boolean

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, enable)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, invisible)
      buf.writeUByte(flag1.toShort)
    }

  }

  protected def create(enable: Boolean, invisible: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val enable = BooleanByteWrapper.getFlag(flag1, 0)
    val invisible = BooleanByteWrapper.getFlag(flag1, 1)

    create(enable, invisible)
  }

}

object BasicSetAwayModeRequestMessage extends BasicSetAwayModeRequestMessage {
  case class MessageImpl(enable: Boolean, invisible: Boolean) extends Message
  type Target = MessageImpl

  override def create(enable: Boolean, invisible: Boolean) = MessageImpl(enable, invisible)

  def apply(enable: Boolean, invisible: Boolean) = create(enable, invisible)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

