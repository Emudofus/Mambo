




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryPresetItemUpdateErrorMessage extends MessageDeserializer {
  val messageId = 6211

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryPresetItemUpdateErrorMessage.messageId

    val code: Byte

    def serialize(buf: Buffer) {
      buf.writeByte(code)
    }

  }

  protected def create(code: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val code = buf.readByte()

    create(code)
  }

}

object InventoryPresetItemUpdateErrorMessage extends InventoryPresetItemUpdateErrorMessage {
  case class MessageImpl(code: Byte) extends Message
  type Target = MessageImpl

  override def create(code: Byte) = MessageImpl(code)

  def apply(code: Byte) = create(code)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

