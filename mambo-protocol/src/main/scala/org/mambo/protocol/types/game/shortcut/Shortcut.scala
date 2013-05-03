




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait Shortcut extends TypeDeserializer {
  val typeId = 369

  protected trait Type extends BaseType with Serializable {
    val typeId = Shortcut.typeId

    val slot: Int

    def serialize(buf: Buffer) {
      buf.writeInt(slot)
    }

  }

  protected def create(slot: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val slot = buf.readInt()

    create(slot)
  }

}

object Shortcut extends Shortcut {
  case class TypeImpl(slot: Int) extends Type
  override def create(slot: Int) = TypeImpl(slot)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(slot: Int) = create(slot)

  type Target = TypeImpl

}

