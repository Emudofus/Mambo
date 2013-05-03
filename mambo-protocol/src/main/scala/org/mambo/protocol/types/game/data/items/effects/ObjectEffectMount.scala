




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffectMount extends ObjectEffect {
  override val typeId = 179

  protected trait Type extends ObjectEffect.Type with Serializable {
    override val typeId = ObjectEffectMount.typeId

    val mountId: Int
    val date: Double
    val modelId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(mountId)
      buf.writeDouble(date)
      buf.writeShort(modelId)
    }

  }

  protected def create(actionId: Short, mountId: Int, date: Double, modelId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val mountId = buf.readInt()
    val date = buf.readDouble()
    val modelId = buf.readShort()

    create(actionId, mountId, date, modelId)
  }

}

object ObjectEffectMount extends ObjectEffectMount {
  case class TypeImpl(actionId: Short, mountId: Int, date: Double, modelId: Short) extends Type
  override def create(actionId: Short, mountId: Int, date: Double, modelId: Short) = TypeImpl(actionId, mountId, date, modelId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short, mountId: Int, date: Double, modelId: Short) = create(actionId, mountId, date, modelId)

  type Target = TypeImpl

}

