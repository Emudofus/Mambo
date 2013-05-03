




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AlignmentBonusInformations extends TypeDeserializer {
  val typeId = 135

  protected trait Type extends BaseType with Serializable {
    val typeId = AlignmentBonusInformations.typeId

    val pctbonus: Int
    val grademult: Double

    def serialize(buf: Buffer) {
      buf.writeInt(pctbonus)
      buf.writeDouble(grademult)
    }

  }

  protected def create(pctbonus: Int, grademult: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val pctbonus = buf.readInt()
    val grademult = buf.readDouble()

    create(pctbonus, grademult)
  }

}

object AlignmentBonusInformations extends AlignmentBonusInformations {
  case class TypeImpl(pctbonus: Int, grademult: Double) extends Type
  override def create(pctbonus: Int, grademult: Double) = TypeImpl(pctbonus, grademult)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(pctbonus: Int, grademult: Double) = create(pctbonus, grademult)

  type Target = TypeImpl

}

