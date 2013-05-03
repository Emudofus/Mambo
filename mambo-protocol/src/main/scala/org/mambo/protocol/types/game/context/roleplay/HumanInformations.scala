




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HumanInformations extends TypeDeserializer {
  val typeId = 157

  protected trait Type extends BaseType with Serializable {
    val typeId = HumanInformations.typeId

    val restrictions: ActorRestrictionsInformations.TypeImpl
    val sex: Boolean
    val options: Seq[HumanOption.TypeImpl]

    def serialize(buf: Buffer) {
      restrictions.serialize(buf)
      buf.writeBoolean(sex)
      buf.writeUShort(options.length)
      for (entry <- options) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(restrictions: ActorRestrictionsInformations.TypeImpl, sex: Boolean, options: Seq[HumanOption.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val restrictions = ActorRestrictionsInformations.deserialize(buf)
    val sex = buf.readBoolean()
    val options = {
      val builder = collection.immutable.Seq.newBuilder[HumanOption.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[HumanOption.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(restrictions, sex, options)
  }

}

object HumanInformations extends HumanInformations {
  case class TypeImpl(restrictions: ActorRestrictionsInformations.TypeImpl, sex: Boolean, options: Seq[HumanOption.TypeImpl]) extends Type
  override def create(restrictions: ActorRestrictionsInformations.TypeImpl, sex: Boolean, options: Seq[HumanOption.TypeImpl]) = TypeImpl(restrictions, sex, options)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(restrictions: ActorRestrictionsInformations.TypeImpl, sex: Boolean, options: Seq[HumanOption.TypeImpl]) = create(restrictions, sex, options)

  type Target = TypeImpl

}

