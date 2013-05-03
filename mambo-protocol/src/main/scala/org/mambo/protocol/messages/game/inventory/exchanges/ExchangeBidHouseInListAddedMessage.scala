




















// Generated on 05/03/2013 10:34:53
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeBidHouseInListAddedMessage extends MessageDeserializer {
  val messageId = 5949

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeBidHouseInListAddedMessage.messageId

    val itemUID: Int
    val objGenericId: Int
    val powerRate: Short
    val overMax: Boolean
    val effects: Seq[ObjectEffect.TypeImpl]
    val prices: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeInt(itemUID)
      buf.writeInt(objGenericId)
      buf.writeShort(powerRate)
      buf.writeBoolean(overMax)
      buf.writeUShort(effects.length)
      for (entry <- effects) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
      buf.writeUShort(prices.length)
      for (entry <- prices) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(itemUID: Int, objGenericId: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
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

object ExchangeBidHouseInListAddedMessage extends ExchangeBidHouseInListAddedMessage {
  case class MessageImpl(itemUID: Int, objGenericId: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(itemUID: Int, objGenericId: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) = MessageImpl(itemUID, objGenericId, powerRate, overMax, effects, prices)

  def apply(itemUID: Int, objGenericId: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) = create(itemUID, objGenericId, powerRate, overMax, effects, prices)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

