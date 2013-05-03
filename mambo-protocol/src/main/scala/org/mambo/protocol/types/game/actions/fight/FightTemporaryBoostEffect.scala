




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTemporaryBoostEffect extends AbstractFightDispellableEffect {
  override val typeId = 209

  protected trait Type extends AbstractFightDispellableEffect.Type with Serializable {
    override val typeId = FightTemporaryBoostEffect.typeId

    val delta: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(delta)
    }

  }

  protected def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, delta: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val uid = buf.readInt()
    val targetId = buf.readInt()
    val turnDuration = buf.readShort()
    val dispelable = buf.readByte()
    val spellId = buf.readShort()
    val parentBoostUid = buf.readInt()
    val delta = buf.readShort()

    create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta)
  }

}

object FightTemporaryBoostEffect extends FightTemporaryBoostEffect {
  case class TypeImpl(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, delta: Short) extends Type
  override def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, delta: Short) = TypeImpl(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, delta: Short) = create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta)

  type Target = TypeImpl

}

