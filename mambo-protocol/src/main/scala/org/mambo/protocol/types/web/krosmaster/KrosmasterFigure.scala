




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait KrosmasterFigure extends TypeDeserializer {
  val typeId = 397

  protected trait Type extends BaseType with Serializable {
    val typeId = KrosmasterFigure.typeId

    val uid: String
    val figure: Short
    val pedestal: Short
    val bound: Boolean

    def serialize(buf: Buffer) {
      buf.writeString(uid)
      buf.writeShort(figure)
      buf.writeShort(pedestal)
      buf.writeBoolean(bound)
    }

  }

  protected def create(uid: String, figure: Short, pedestal: Short, bound: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val uid = buf.readString()
    val figure = buf.readShort()
    val pedestal = buf.readShort()
    val bound = buf.readBoolean()

    create(uid, figure, pedestal, bound)
  }

}

object KrosmasterFigure extends KrosmasterFigure {
  case class TypeImpl(uid: String, figure: Short, pedestal: Short, bound: Boolean) extends Type
  override def create(uid: String, figure: Short, pedestal: Short, bound: Boolean) = TypeImpl(uid, figure, pedestal, bound)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uid: String, figure: Short, pedestal: Short, bound: Boolean) = create(uid, figure, pedestal, bound)

  type Target = TypeImpl

}

