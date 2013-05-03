




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait TaxCollectorInformationsInWaitForHelpState extends TaxCollectorInformations {
  override val typeId = 166

  protected trait Type extends TaxCollectorInformations.Type with Serializable {
    override val typeId = TaxCollectorInformationsInWaitForHelpState.typeId

    val waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      waitingForHelpInfo.serialize(buf)
    }

  }

  protected def create(uniqueId: Int, firtNameId: Short, lastNameId: Short, additionalInfos: AdditionalTaxCollectorInformations.TypeImpl, worldX: Short, worldY: Short, subAreaId: Short, state: Byte, look: EntityLook.TypeImpl, kamas: Int, experience: Double, pods: Int, itemsValue: Int, waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
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
    val waitingForHelpInfo = ProtectedEntityWaitingForHelpInfo.deserialize(buf)

    create(uniqueId, firtNameId, lastNameId, additionalInfos, worldX, worldY, subAreaId, state, look, kamas, experience, pods, itemsValue, waitingForHelpInfo)
  }

}

object TaxCollectorInformationsInWaitForHelpState extends TaxCollectorInformationsInWaitForHelpState {
  case class TypeImpl(uniqueId: Int, firtNameId: Short, lastNameId: Short, additionalInfos: AdditionalTaxCollectorInformations.TypeImpl, worldX: Short, worldY: Short, subAreaId: Short, state: Byte, look: EntityLook.TypeImpl, kamas: Int, experience: Double, pods: Int, itemsValue: Int, waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl) extends Type
  override def create(uniqueId: Int, firtNameId: Short, lastNameId: Short, additionalInfos: AdditionalTaxCollectorInformations.TypeImpl, worldX: Short, worldY: Short, subAreaId: Short, state: Byte, look: EntityLook.TypeImpl, kamas: Int, experience: Double, pods: Int, itemsValue: Int, waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl) = TypeImpl(uniqueId, firtNameId, lastNameId, additionalInfos, worldX, worldY, subAreaId, state, look, kamas, experience, pods, itemsValue, waitingForHelpInfo)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uniqueId: Int, firtNameId: Short, lastNameId: Short, additionalInfos: AdditionalTaxCollectorInformations.TypeImpl, worldX: Short, worldY: Short, subAreaId: Short, state: Byte, look: EntityLook.TypeImpl, kamas: Int, experience: Double, pods: Int, itemsValue: Int, waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl) = create(uniqueId, firtNameId, lastNameId, additionalInfos, worldX, worldY, subAreaId, state, look, kamas, experience, pods, itemsValue, waitingForHelpInfo)

  type Target = TypeImpl

}

