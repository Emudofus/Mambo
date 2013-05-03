




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AbstractFightDispellableEffect extends TypeDeserializer {
  val typeId = 206

  protected trait Type extends BaseType with Serializable {
    val typeId = AbstractFightDispellableEffect.typeId

    val uid: Int
    val targetId: Int
    val turnDuration: Short
    val dispelable: Byte
    val spellId: Short
    val parentBoostUid: Int

    def serialize(buf: Buffer) {
      buf.writeInt(uid)
      buf.writeInt(targetId)
      buf.writeShort(turnDuration)
      buf.writeByte(dispelable)
      buf.writeShort(spellId)
      buf.writeInt(parentBoostUid)
    }

  }

  protected def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val uid = buf.readInt()
    val targetId = buf.readInt()
    val turnDuration = buf.readShort()
    val dispelable = buf.readByte()
    val spellId = buf.readShort()
    val parentBoostUid = buf.readInt()

    create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid)
  }

}

object AbstractFightDispellableEffect extends AbstractFightDispellableEffect {
  case class TypeImpl(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int) extends Type
  override def create(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int) = TypeImpl(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(uid: Int, targetId: Int, turnDuration: Short, dispelable: Byte, spellId: Short, parentBoostUid: Int) = create(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid)

  type Target = TypeImpl

}

