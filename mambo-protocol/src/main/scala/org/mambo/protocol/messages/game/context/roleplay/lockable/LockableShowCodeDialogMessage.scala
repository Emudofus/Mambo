




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LockableShowCodeDialogMessage extends MessageDeserializer {
  val messageId = 5740

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LockableShowCodeDialogMessage.messageId

    val changeOrUse: Boolean
    val codeSize: Byte

    def serialize(buf: Buffer) {
      buf.writeBoolean(changeOrUse)
      buf.writeByte(codeSize)
    }

  }

  protected def create(changeOrUse: Boolean, codeSize: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val changeOrUse = buf.readBoolean()
    val codeSize = buf.readByte()

    create(changeOrUse, codeSize)
  }

}

object LockableShowCodeDialogMessage extends LockableShowCodeDialogMessage {
  case class MessageImpl(changeOrUse: Boolean, codeSize: Byte) extends Message
  type Target = MessageImpl

  override def create(changeOrUse: Boolean, codeSize: Byte) = MessageImpl(changeOrUse, codeSize)

  def apply(changeOrUse: Boolean, codeSize: Byte) = create(changeOrUse, codeSize)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

