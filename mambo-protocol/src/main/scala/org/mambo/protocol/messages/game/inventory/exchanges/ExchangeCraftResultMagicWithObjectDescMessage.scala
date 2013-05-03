




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeCraftResultMagicWithObjectDescMessage extends ExchangeCraftResultWithObjectDescMessage {
  override val messageId = 6188

  protected trait Message extends ExchangeCraftResultWithObjectDescMessage.Message with Serializable {
    override val messageId = ExchangeCraftResultMagicWithObjectDescMessage.messageId

    val magicPoolStatus: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(magicPoolStatus)
    }

  }

  protected def create(craftResult: Byte, objectInfo: ObjectItemNotInContainer.TypeImpl, magicPoolStatus: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val craftResult = buf.readByte()
    val objectInfo = ObjectItemNotInContainer.deserialize(buf)
    val magicPoolStatus = buf.readByte()

    create(craftResult, objectInfo, magicPoolStatus)
  }

}

object ExchangeCraftResultMagicWithObjectDescMessage extends ExchangeCraftResultMagicWithObjectDescMessage {
  case class MessageImpl(craftResult: Byte, objectInfo: ObjectItemNotInContainer.TypeImpl, magicPoolStatus: Byte) extends Message
  type Target = MessageImpl

  override def create(craftResult: Byte, objectInfo: ObjectItemNotInContainer.TypeImpl, magicPoolStatus: Byte) = MessageImpl(craftResult, objectInfo, magicPoolStatus)

  def apply(craftResult: Byte, objectInfo: ObjectItemNotInContainer.TypeImpl, magicPoolStatus: Byte) = create(craftResult, objectInfo, magicPoolStatus)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

