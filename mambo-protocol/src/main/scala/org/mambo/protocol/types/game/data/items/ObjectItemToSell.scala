




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectItemToSell extends Item {
  override val typeId = 120

  protected trait Type extends Item.Type with Serializable {
    override val typeId = ObjectItemToSell.typeId

    val objectGID: Short
    val powerRate: Short
    val overMax: Boolean
    val effects: Seq[ObjectEffect.TypeImpl]
    val objectUID: Int
    val quantity: Int
    val objectPrice: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(objectGID)
      buf.writeShort(powerRate)
      buf.writeBoolean(overMax)
      buf.writeUShort(effects.length)
      for (entry <- effects) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
      buf.writeInt(objectUID)
      buf.writeInt(quantity)
      buf.writeInt(objectPrice)
    }

  }

  protected def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int, objectPrice: Int): Target = throw new IllegalAccessException

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

    create(objectGID, powerRate, overMax, effects, objectUID, quantity, objectPrice)
  }

}

object ObjectItemToSell extends ObjectItemToSell {
  case class TypeImpl(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int, objectPrice: Int) extends Type
  override def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int, objectPrice: Int) = TypeImpl(objectGID, powerRate, overMax, effects, objectUID, quantity, objectPrice)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int, objectPrice: Int) = create(objectGID, powerRate, overMax, effects, objectUID, quantity, objectPrice)

  type Target = TypeImpl

}

