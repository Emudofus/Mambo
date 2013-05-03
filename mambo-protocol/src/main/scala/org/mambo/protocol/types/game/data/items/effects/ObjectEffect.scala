




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ObjectEffect extends TypeDeserializer {
  val typeId = 76

  protected trait Type extends BaseType with Serializable {
    val typeId = ObjectEffect.typeId

    val actionId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(actionId)
    }

  }

  protected def create(actionId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()

    create(actionId)
  }

}

object ObjectEffect extends ObjectEffect {
  case class TypeImpl(actionId: Short) extends Type
  override def create(actionId: Short) = TypeImpl(actionId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(actionId: Short) = create(actionId)

  type Target = TypeImpl

}

