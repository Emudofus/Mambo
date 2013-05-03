




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectItemToSellInBid extends ObjectItemToSell {
  override val typeId = 164

  protected trait Type extends ObjectItemToSell.Type with Serializable {
    override val typeId = ObjectItemToSellInBid.typeId

    val unsoldDelay: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(unsoldDelay)
    }

  }

  protected def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int, objectPrice: Int, unsoldDelay: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val objectGID = buf.readShort()
    val powerRate = buf.readShort()
    val overMax = buf.readBoolean()
    val effects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectEffect.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[ObjectEffect.TypeImpl](buf.readShort());
      }
      builder.result()
    }
    val objectUID = buf.readInt()
    val quantity = buf.readInt()
    val objectPrice = buf.readInt()
    val unsoldDelay = buf.readShort()

    create(objectGID, powerRate, overMax, effects, objectUID, quantity, objectPrice, unsoldDelay)
  }

}

object ObjectItemToSellInBid extends ObjectItemToSellInBid {
  case class TypeImpl(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int, objectPrice: Int, unsoldDelay: Short) extends Type
  override def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int, objectPrice: Int, unsoldDelay: Short) = TypeImpl(objectGID, powerRate, overMax, effects, objectUID, quantity, objectPrice, unsoldDelay)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int, objectPrice: Int, unsoldDelay: Short) = create(objectGID, powerRate, overMax, effects, objectUID, quantity, objectPrice, unsoldDelay)

  type Target = TypeImpl

}

