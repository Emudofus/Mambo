




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeCraftResultWithObjectIdMessage extends ExchangeCraftResultMessage {
  override val messageId = 6000

  protected trait Message extends ExchangeCraftResultMessage.Message with Serializable {
    override val messageId = ExchangeCraftResultWithObjectIdMessage.messageId

    val objectGenericId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(objectGenericId)
    }

  }

  protected def create(craftResult: Byte, objectGenericId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val craftResult = buf.readByte()
    val objectGenericId = buf.readInt()

    create(craftResult, objectGenericId)
  }

}

object ExchangeCraftResultWithObjectIdMessage extends ExchangeCraftResultWithObjectIdMessage {
  case class MessageImpl(craftResult: Byte, objectGenericId: Int) extends Message
  type Target = MessageImpl

  override def create(craftResult: Byte, objectGenericId: Int) = MessageImpl(craftResult, objectGenericId)

  def apply(craftResult: Byte, objectGenericId: Int) = create(craftResult, objectGenericId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

