




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait HumanOptionEmote extends HumanOption {
  override val typeId = 407

  protected trait Type extends HumanOption.Type with Serializable {
    override val typeId = HumanOptionEmote.typeId

    val emoteId: Byte
    val emoteStartTime: Double

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(emoteId)
      buf.writeDouble(emoteStartTime)
    }

  }

  protected def create(emoteId: Byte, emoteStartTime: Double): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val emoteId = buf.readByte()
    val emoteStartTime = buf.readDouble()

    create(emoteId, emoteStartTime)
  }

}

object HumanOptionEmote extends HumanOptionEmote {
  case class TypeImpl(emoteId: Byte, emoteStartTime: Double) extends Type
  override def create(emoteId: Byte, emoteStartTime: Double) = TypeImpl(emoteId, emoteStartTime)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(emoteId: Byte, emoteStartTime: Double) = create(emoteId, emoteStartTime)

  type Target = TypeImpl

}

