




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HumanOptionTitle extends HumanOption {
  override val typeId = 408

  protected trait Type extends HumanOption.Type with Serializable {
    override val typeId = HumanOptionTitle.typeId

    val titleId: Short
    val titleParam: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(titleId)
      buf.writeString(titleParam)
    }

  }

  protected def create(titleId: Short, titleParam: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val titleId = buf.readShort()
    val titleParam = buf.readString()

    create(titleId, titleParam)
  }

}

object HumanOptionTitle extends HumanOptionTitle {
  case class TypeImpl(titleId: Short, titleParam: String) extends Type
  override def create(titleId: Short, titleParam: String) = TypeImpl(titleId, titleParam)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(titleId: Short, titleParam: String) = create(titleId, titleParam)

  type Target = TypeImpl

}

