




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectItem extends Item {
  override val typeId = 37

  protected trait Type extends Item.Type with Serializable {
    override val typeId = ObjectItem.typeId

    val position: UByte
    val objectGID: Short
    val powerRate: Short
    val overMax: Boolean
    val effects: Seq[ObjectEffect.TypeImpl]
    val objectUID: Int
    val quantity: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUByte(position)
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
    }

  }

  protected def create(position: UByte, objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val position = buf.readUByte()
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

    create(position, objectGID, powerRate, overMax, effects, objectUID, quantity)
  }

}

object ObjectItem extends ObjectItem {
  case class TypeImpl(position: UByte, objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int) extends Type
  override def create(position: UByte, objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int) = TypeImpl(position, objectGID, powerRate, overMax, effects, objectUID, quantity)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(position: UByte, objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], objectUID: Int, quantity: Int) = create(position, objectGID, powerRate, overMax, effects, objectUID, quantity)

  type Target = TypeImpl

}

