




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartedWithStorageMessage extends ExchangeStartedMessage {
  override val messageId = 6236

  protected trait Message extends ExchangeStartedMessage.Message with Serializable {
    override val messageId = ExchangeStartedWithStorageMessage.messageId

    val storageMaxSlot: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(storageMaxSlot)
    }

  }

  protected def create(exchangeType: Byte, storageMaxSlot: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val exchangeType = buf.readByte()
    val storageMaxSlot = buf.readInt()

    create(exchangeType, storageMaxSlot)
  }

}

object ExchangeStartedWithStorageMessage extends ExchangeStartedWithStorageMessage {
  case class MessageImpl(exchangeType: Byte, storageMaxSlot: Int) extends Message
  type Target = MessageImpl

  override def create(exchangeType: Byte, storageMaxSlot: Int) = MessageImpl(exchangeType, storageMaxSlot)

  def apply(exchangeType: Byte, storageMaxSlot: Int) = create(exchangeType, storageMaxSlot)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

