




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait PaddockInformations extends TypeDeserializer {
  val typeId = 132

  protected trait Type extends BaseType with Serializable {
    val typeId = PaddockInformations.typeId

    val maxOutdoorMount: Short
    val maxItems: Short

    def serialize(buf: Buffer) {
      buf.writeShort(maxOutdoorMount)
      buf.writeShort(maxItems)
    }

  }

  protected def create(maxOutdoorMount: Short, maxItems: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val maxOutdoorMount = buf.readShort()
    val maxItems = buf.readShort()

    create(maxOutdoorMount, maxItems)
  }

}

object PaddockInformations extends PaddockInformations {
  case class TypeImpl(maxOutdoorMount: Short, maxItems: Short) extends Type
  override def create(maxOutdoorMount: Short, maxItems: Short) = TypeImpl(maxOutdoorMount, maxItems)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(maxOutdoorMount: Short, maxItems: Short) = create(maxOutdoorMount, maxItems)

  type Target = TypeImpl

}

