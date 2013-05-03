




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait TaxCollectorInformations extends TypeDeserializer {
  val typeId = 167

  protected trait Type extends BaseType with Serializable {
    val typeId = TaxCollectorInformations.typeId

    val uniqueId: Int
    val firtNameId: Short
    val lastNameId: Short
    val additionalInfos: AdditionalTaxCollectorInformations.TypeImpl
    val worldX: Short
    val worldY: Short
    val subAreaId: Short
    val state: Byte
    val look: EntityLook.TypeImpl
    val kamas: Int
    val experience: Double
    val pods: Int
    val itemsValue: Int

    def serialize(buf: Buffer) {
      buf.writeInt(uniqueId)
      buf.writeShort(firtNameId)
      buf.writeShort(lastNameId)
      additionalInfos.serialize(buf)
      buf.writeShort(worldX)
      buf.writeShort(worldY)
      buf.writeShort(subAreaId)
      buf.writeByte(state)
      look.serialize(buf)
      buf.writeInt(kamas)
      buf.writeDouble(experience)
      buf.writeInt(pods)
      buf.writeInt(itemsValue)
    }

  }

  protected def create(uniqueId: Int, firtNameId: Short, lastNameId: Short, additionalInfos: AdditionalTaxCollectorInformations.TypeImpl, worldX: Short, worldY: Short, subAreaId: Short, state: Byte, look: EntityLook.TypeImpl, kamas: Int, experience: Double, pods: Int, itemsValue: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val uniqueId = buf.readInt()
    val firtNameId = buf.readShort()
    val lastNameId = buf.readShort()
    val additionalInfos = AdditionalTaxCollectorInformations.deserialize(buf)
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val subAreaId = buf.readShort()
    val state = buf.readByte()
    val look = EntityLook.deserialize(buf)
    val kamas = buf.readInt()
    val experience = buf.readDouble()
    val pods = buf.readInt()
    val itemsValue = buf.readInt()

    create(uniqueId, firtNameId, lastNameId, additionalInfos, worldX, worldY, subAreaId, state, look, kamas, experience, pods, itemsValue)
  }

}

object TaxCollectorInformations extends TaxCollectorInformations {
  case class TypeImpl(uniqueId: Int, firtNameId: Short, lastNameId: Short, additionalInfos: AdditionalTaxCollectorInformations.TypeImpl, worldX: Short, worldY: Short, subAreaId: Short, state: Byte, look: EntityLook.TypeImpl, kamas: Int, experience: Double, pods: Int, itemsValue: Int) extends Type
  override def create(uniqueId: Int, firtNameId: Short, lastNameId: Short, additionalInfos: AdditionalTaxCollectorInformations.TypeImpl, worldX: Short, worldY: Short, subAreaId: Short, state: Byte, look: EntityLook.TypeImpl, kamas: Int, experience: Double, pods: Int, itemsValue: Int) = TypeImpl(uniqueId, firtNameId, lastNameId, additionalInfos, worldX, worldY, subAreaId, state, look, kamas, experience, pods, itemsValue)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uniqueId: Int, firtNameId: Short, lastNameId: Short, additionalInfos: AdditionalTaxCollectorInformations.TypeImpl, worldX: Short, worldY: Short, subAreaId: Short, state: Byte, look: EntityLook.TypeImpl, kamas: Int, experience: Double, pods: Int, itemsValue: Int) = create(uniqueId, firtNameId, lastNameId, additionalInfos, worldX, worldY, subAreaId, state, look, kamas, experience, pods, itemsValue)

  type Target = TypeImpl

}

