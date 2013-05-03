




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StartupActionFinishedMessage extends MessageDeserializer {
  val messageId = 1304

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StartupActionFinishedMessage.messageId

    val success: Boolean
    val automaticAction: Boolean
    val actionId: Int

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, success)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, automaticAction)
      buf.writeUByte(flag1.toShort)
      buf.writeInt(actionId)
    }

  }

  protected def create(success: Boolean, automaticAction: Boolean, actionId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val success = BooleanByteWrapper.getFlag(flag1, 0)
    val automaticAction = BooleanByteWrapper.getFlag(flag1, 1)
    val actionId = buf.readInt()

    create(success, automaticAction, actionId)
  }

}

object StartupActionFinishedMessage extends StartupActionFinishedMessage {
  case class MessageImpl(success: Boolean, automaticAction: Boolean, actionId: Int) extends Message
  type Target = MessageImpl

  override def create(success: Boolean, automaticAction: Boolean, actionId: Int) = MessageImpl(success, automaticAction, actionId)

  def apply(success: Boolean, automaticAction: Boolean, actionId: Int) = create(success, automaticAction, actionId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

