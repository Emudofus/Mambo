




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectItemInformationWithQuantity extends ObjectItemMinimalInformation {
  override val typeId = 387

  protected trait Type extends ObjectItemMinimalInformation.Type with Serializable {
    override val typeId = ObjectItemInformationWithQuantity.typeId

    val quantity: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(quantity)
    }

  }

  protected def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], quantity: Int): Target = throw new IllegalAccessException

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
    val quantity = buf.readInt()

    create(objectGID, powerRate, overMax, effects, quantity)
  }

}

object ObjectItemInformationWithQuantity extends ObjectItemInformationWithQuantity {
  case class TypeImpl(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], quantity: Int) extends Type
  override def create(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], quantity: Int) = TypeImpl(objectGID, powerRate, overMax, effects, quantity)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objectGID: Short, powerRate: Short, overMax: Boolean, effects: Seq[ObjectEffect.TypeImpl], quantity: Int) = create(objectGID, powerRate, overMax, effects, quantity)

  type Target = TypeImpl

}

