




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait BidExchangerObjectInfo extends TypeDeserializer {
  val typeId = 122

  protected trait Type extends BaseType with Serializable {
    val typeId = BidExchangerObjectInfo.typeId

    val objectUID: Int
    val powerRate: Short
    val overMax: Boolean
    val effects: Seq[ObjectEffect.TypeImpl]
    val prices: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeInt(objectUID)
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

  protected def create(objectUID: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectUID = buf.readInt()
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

    create(objectUID, powerRate, overMax, effects, prices)
  }

}

object BidExchangerObjectInfo extends BidExchangerObjectInfo {
  case class TypeImpl(objectUID: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) extends Type
  override def create(objectUID: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) = TypeImpl(objectUID, powerRate, overMax, effects, prices)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectUID: Int, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], prices: Seq[Int]) = create(objectUID, powerRate, overMax, effects, prices)

  type Target = TypeImpl

}

