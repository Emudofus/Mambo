




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterBaseCharacteristic extends TypeDeserializer {
  val typeId = 4

  protected trait Type extends BaseType with Serializable {
    val typeId = CharacterBaseCharacteristic.typeId

    val base: Short
    val objectsAndMountBonus: Short
    val alignGiftBonus: Short
    val contextModif: Short

    def serialize(buf: Buffer) {
      buf.writeShort(base)
      buf.writeShort(objectsAndMountBonus)
      buf.writeShort(alignGiftBonus)
      buf.writeShort(contextModif)
    }

  }

  protected def create(base: Short, objectsAndMountBonus: Short, alignGiftBonus: Short, contextModif: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val base = buf.readShort()
    val objectsAndMountBonus = buf.readShort()
    val alignGiftBonus = buf.readShort()
    val contextModif = buf.readShort()

    create(base, objectsAndMountBonus, alignGiftBonus, contextModif)
  }

}

object CharacterBaseCharacteristic extends CharacterBaseCharacteristic {
  case class TypeImpl(base: Short, objectsAndMountBonus: Short, alignGiftBonus: Short, contextModif: Short) extends Type
  override def create(base: Short, objectsAndMountBonus: Short, alignGiftBonus: Short, contextModif: Short) = TypeImpl(base, objectsAndMountBonus, alignGiftBonus, contextModif)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(base: Short, objectsAndMountBonus: Short, alignGiftBonus: Short, contextModif: Short) = create(base, objectsAndMountBonus, alignGiftBonus, contextModif)

  type Target = TypeImpl

}

