




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeCraftInformationObjectMessage extends ExchangeCraftResultWithObjectIdMessage {
  override val messageId = 5794

  protected trait Message extends ExchangeCraftResultWithObjectIdMessage.Message with Serializable {
    override val messageId = ExchangeCraftInformationObjectMessage.messageId

    val playerId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(playerId)
    }

  }

  protected def create(craftResult: Byte, objectGenericId: Int, playerId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val craftResult = buf.readByte()
    val objectGenericId = buf.readInt()
    val playerId = buf.readInt()

    create(craftResult, objectGenericId, playerId)
  }

}

object ExchangeCraftInformationObjectMessage extends ExchangeCraftInformationObjectMessage {
  case class MessageImpl(craftResult: Byte, objectGenericId: Int, playerId: Int) extends Message
  type Target = MessageImpl

  override def create(craftResult: Byte, objectGenericId: Int, playerId: Int) = MessageImpl(craftResult, objectGenericId, playerId)

  def apply(craftResult: Byte, objectGenericId: Int, playerId: Int) = create(craftResult, objectGenericId, playerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

