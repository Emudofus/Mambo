




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectItemMinimalInformation extends Item {
  override val typeId = 124

  protected trait Type extends Item.Type with Serializable {
    override val typeId = ObjectItemMinimalInformation.typeId

    val objectGID: Short
    val powerRate: Short
    val overMax: Boolean
    val effects: Seq[ObjectEffect.TypeImpl]

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
    }

  }

  protected def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl]): Target = throw new IllegalAccessException

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

    create(objectGID, powerRate, overMax, effects)
  }

}

object ObjectItemMinimalInformation extends ObjectItemMinimalInformation {
  case class TypeImpl(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl]) extends Type
  override def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl]) = TypeImpl(objectGID, powerRate, overMax, effects)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl]) = create(objectGID, powerRate, overMax, effects)

  type Target = TypeImpl

}

