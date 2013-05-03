




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightLoot extends TypeDeserializer {
  val typeId = 41

  protected trait Type extends BaseType with Serializable {
    val typeId = FightLoot.typeId

    val objects: Seq[Short]
    val kamas: Int

    def serialize(buf: Buffer) {
      buf.writeUShort(objects.length)
      for (entry <- objects) {
        buf.writeShort(entry)
      }
      buf.writeInt(kamas)
    }

  }

  protected def create(objects: Seq[Short], kamas: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objects = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val kamas = buf.readInt()

    create(objects, kamas)
  }

}

object FightLoot extends FightLoot {
  case class TypeImpl(objects: Seq[Short], kamas: Int) extends Type
  override def create(objects: Seq[Short], kamas: Int) = TypeImpl(objects, kamas)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(objects: Seq[Short], kamas: Int) = create(objects, kamas)

  type Target = TypeImpl

}

