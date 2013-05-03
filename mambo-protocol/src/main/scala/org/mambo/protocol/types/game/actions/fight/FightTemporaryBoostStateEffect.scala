




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTemporaryBoostStateEffect extends FightTemporaryBoostEffect {
  override val typeId = 214

  protected trait Type extends FightTemporaryBoostEffect.Type with Serializable {
    override val typeId = FightTemporaryBoostStateEffect.typeId

    val stateId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(stateId)
    }

  }

  protected def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, delta: Short, stateId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val uid = buf.readInt()
    val targetId = buf.readInt()
    val turnDuration = buf.readShort()
    val dispelable = buf.readByte()
    val spellId = buf.readShort()
    val parentBoostUid = buf.readInt()
    val delta = buf.readShort()
    val stateId = buf.readShort()

    create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta, stateId)
  }

}

object FightTemporaryBoostStateEffect extends FightTemporaryBoostStateEffect {
  case class TypeImpl(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, delta: Short, stateId: Short) extends Type
  override def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, delta: Short, stateId: Short) = TypeImpl(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta, stateId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, delta: Short, stateId: Short) = create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta, stateId)

  type Target = TypeImpl

}

