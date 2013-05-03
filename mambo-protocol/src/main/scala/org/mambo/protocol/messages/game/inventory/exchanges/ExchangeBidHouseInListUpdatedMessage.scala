




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseInListUpdatedMessage extends ExchangeBidHouseInListAddedMessage {
  override val messageId = 6337

  protected trait Message extends ExchangeBidHouseInListAddedMessage.Message with Serializable {
    override val messageId = ExchangeBidHouseInListUpdatedMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val itemUID = buf.readInt()
    val objGenericId = buf.readInt()
    val powerRate = buf.readShort()
    val overMax = buf.readBoolean()
    val effects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectEffect.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[ObjectEffect.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val prices = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(itemUID, objGenericId, powerRate, overMax, effects, prices)
  }

}

object ExchangeBidHouseInListUpdatedMessage extends ExchangeBidHouseInListUpdatedMessage {
  case class MessageImpl(itemUID: Int, objGenericId: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(itemUID: Int, objGenericId: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) = MessageImpl(itemUID, objGenericId, powerRate, overMax, effects, prices)

  def apply(itemUID: Int, objGenericId: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) = create(itemUID, objGenericId, powerRate, overMax, effects, prices)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

