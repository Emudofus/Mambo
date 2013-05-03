




















// Generated on 05/03/2013 10:34:55
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartedWithPodsMessage extends ExchangeStartedMessage {
  override val messageId = 6129

  protected trait Message extends ExchangeStartedMessage.Message with Serializable {
    override val messageId = ExchangeStartedWithPodsMessage.messageId

    val firstCharacterId: Int
    val firstCharacterCurrentWeight: Int
    val firstCharacterMaxWeight: Int
    val secondCharacterId: Int
    val secondCharacterCurrentWeight: Int
    val secondCharacterMaxWeight: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(firstCharacterId)
      buf.writeInt(firstCharacterCurrentWeight)
      buf.writeInt(firstCharacterMaxWeight)
      buf.writeInt(secondCharacterId)
      buf.writeInt(secondCharacterCurrentWeight)
      buf.writeInt(secondCharacterMaxWeight)
    }

  }

  protected def create(exchangeType: Byte, firstCharacterId: Int, firstCharacterCurrentWeight: Int, firstCharacterMaxWeight: Int, secondCharacterId: Int, secondCharacterCurrentWeight: Int, secondCharacterMaxWeight: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val exchangeType = buf.readByte()
    val firstCharacterId = buf.readInt()
    val firstCharacterCurrentWeight = buf.readInt()
    val firstCharacterMaxWeight = buf.readInt()
    val secondCharacterId = buf.readInt()
    val secondCharacterCurrentWeight = buf.readInt()
    val secondCharacterMaxWeight = buf.readInt()

    create(exchangeType, firstCharacterId, firstCharacterCurrentWeight, firstCharacterMaxWeight, secondCharacterId, secondCharacterCurrentWeight, secondCharacterMaxWeight)
  }

}

object ExchangeStartedWithPodsMessage extends ExchangeStartedWithPodsMessage {
  case class MessageImpl(exchangeType: Byte, firstCharacterId: Int, firstCharacterCurrentWeight: Int, firstCharacterMaxWeight: Int, secondCharacterId: Int, secondCharacterCurrentWeight: Int, secondCharacterMaxWeight: Int) extends Message
  type Target = MessageImpl

  override def create(exchangeType: Byte, firstCharacterId: Int, firstCharacterCurrentWeight: Int, firstCharacterMaxWeight: Int, secondCharacterId: Int, secondCharacterCurrentWeight: Int, secondCharacterMaxWeight: Int) = MessageImpl(exchangeType, firstCharacterId, firstCharacterCurrentWeight, firstCharacterMaxWeight, secondCharacterId, secondCharacterCurrentWeight, secondCharacterMaxWeight)

  def apply(exchangeType: Byte, firstCharacterId: Int, firstCharacterCurrentWeight: Int, firstCharacterMaxWeight: Int, secondCharacterId: Int, secondCharacterCurrentWeight: Int, secondCharacterMaxWeight: Int) = create(exchangeType, firstCharacterId, firstCharacterCurrentWeight, firstCharacterMaxWeight, secondCharacterId, secondCharacterCurrentWeight, secondCharacterMaxWeight)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

