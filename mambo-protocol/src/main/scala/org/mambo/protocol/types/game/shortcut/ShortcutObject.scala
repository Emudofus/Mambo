




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait ShortcutObject extends Shortcut {
  override val typeId = 367

  protected trait Type extends Shortcut.Type with Serializable {
    override val typeId = ShortcutObject.typeId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val slot = buf.readInt()

    create(slot)
  }

}

object ShortcutObject extends ShortcutObject {
  case class TypeImpl(slot: Int) extends Type
  override def create(slot: Int) = TypeImpl(slot)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(slot: Int) = create(slot)

  type Target = TypeImpl

}

