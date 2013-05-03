




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HumanOptionFollowers extends HumanOption {
  override val typeId = 410

  protected trait Type extends HumanOption.Type with Serializable {
    override val typeId = HumanOptionFollowers.typeId

    val followingCharactersLook: Seq[IndexedEntityLook.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(followingCharactersLook.length)
      for (entry <- followingCharactersLook) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(followingCharactersLook: Seq[IndexedEntityLook.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val followingCharactersLook = {
      val builder = collection.immutable.Seq.newBuilder[IndexedEntityLook.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += IndexedEntityLook.deserialize(buf)
      }
      builder.result()
    }

    create(followingCharactersLook)
  }

}

object HumanOptionFollowers extends HumanOptionFollowers {
  case class TypeImpl(followingCharactersLook: Seq[IndexedEntityLook.TypeImpl]) extends Type
  override def create(followingCharactersLook: Seq[IndexedEntityLook.TypeImpl]) = TypeImpl(followingCharactersLook)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(followingCharactersLook: Seq[IndexedEntityLook.TypeImpl]) = create(followingCharactersLook)

  type Target = TypeImpl

}

