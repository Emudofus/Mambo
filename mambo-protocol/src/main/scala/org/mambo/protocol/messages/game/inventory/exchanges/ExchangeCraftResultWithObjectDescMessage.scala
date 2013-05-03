




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeCraftResultWithObjectDescMessage extends ExchangeCraftResultMessage {
  override val messageId = 5999

  protected trait Message extends ExchangeCraftResultMessage.Message with Serializable {
    override val messageId = ExchangeCraftResultWithObjectDescMessage.messageId

    val objectInfo: ObjectItemNotInContainer.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      objectInfo.serialize(buf)
    }

  }

  protected def create(craftResult: Byte, objectInfo: ObjectItemNotInContainer.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val craftResult = buf.readByte()
    val objectInfo = ObjectItemNotInContainer.deserialize(buf)

    create(craftResult, objectInfo)
  }

}

object ExchangeCraftResultWithObjectDescMessage extends ExchangeCraftResultWithObjectDescMessage {
  case class MessageImpl(craftResult: Byte, objectInfo: ObjectItemNotInContainer.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(craftResult: Byte, objectInfo: ObjectItemNotInContainer.TypeImpl) = MessageImpl(craftResult, objectInfo)

  def apply(craftResult: Byte, objectInfo: ObjectItemNotInContainer.TypeImpl) = create(craftResult, objectInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

