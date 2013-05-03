




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTemporarySpellImmunityEffect extends AbstractFightDispellableEffect {
  override val typeId = 366

  protected trait Type extends AbstractFightDispellableEffect.Type with Serializable {
    override val typeId = FightTemporarySpellImmunityEffect.typeId

    val immuneSpellId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(immuneSpellId)
    }

  }

  protected def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, immuneSpellId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val uid = buf.readInt()
    val targetId = buf.readInt()
    val turnDuration = buf.readShort()
    val dispelable = buf.readByte()
    val spellId = buf.readShort()
    val parentBoostUid = buf.readInt()
    val immuneSpellId = buf.readInt()

    create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, immuneSpellId)
  }

}

object FightTemporarySpellImmunityEffect extends FightTemporarySpellImmunityEffect {
  case class TypeImpl(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, immuneSpellId: Int) extends Type
  override def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, immuneSpellId: Int) = TypeImpl(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, immuneSpellId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, immuneSpellId: Int) = create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, immuneSpellId)

  type Target = TypeImpl

}

