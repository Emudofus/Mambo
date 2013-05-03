




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightTriggeredEffect extends AbstractFightDispellableEffect {
  override val typeId = 210

  protected trait Type extends AbstractFightDispellableEffect.Type with Serializable {
    override val typeId = FightTriggeredEffect.typeId

    val arg1: Int
    val arg2: Int
    val arg3: Int
    val delay: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(arg1)
      buf.writeInt(arg2)
      buf.writeInt(arg3)
      buf.writeShort(delay)
    }

  }

  protected def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, arg1: Int, arg2: Int, arg3: Int, delay: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val uid = buf.readInt()
    val targetId = buf.readInt()
    val turnDuration = buf.readShort()
    val dispelable = buf.readByte()
    val spellId = buf.readShort()
    val parentBoostUid = buf.readInt()
    val arg1 = buf.readInt()
    val arg2 = buf.readInt()
    val arg3 = buf.readInt()
    val delay = buf.readShort()

    create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, arg1, arg2, arg3, delay)
  }

}

object FightTriggeredEffect extends FightTriggeredEffect {
  case class TypeImpl(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, arg1: Int, arg2: Int, arg3: Int, delay: Short) extends Type
  override def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, arg1: Int, arg2: Int, arg3: Int, delay: Short) = TypeImpl(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, arg1, arg2, arg3, delay)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int, arg1: Int, arg2: Int, arg3: Int, delay: Short) = create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, arg1, arg2, arg3, delay)

  type Target = TypeImpl

}

