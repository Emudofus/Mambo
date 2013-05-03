




















// Generated on 05/03/2013 10:35:06
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait Item extends TypeDeserializer {
  val typeId = 7

  protected trait Type extends BaseType with Serializable {
    val typeId = Item.typeId


    def serialize(buf: Buffer) {
    }

  }

  protected def create(): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {

    create()
  }

}

object Item extends Item {
  case class TypeImpl() extends Type
  override def create() = TypeImpl()

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply() = create()

  type Target = TypeImpl

}

