




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightSpellCastMessage extends AbstractGameActionFightTargetedAbilityMessage {
  override val messageId = 1010

  protected trait Message extends AbstractGameActionFightTargetedAbilityMessage.Message with Serializable {
    override val messageId = GameActionFightSpellCastMessage.messageId

    val spellId: Short
    val spellLevel: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(spellId)
      buf.writeByte(spellLevel)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean, spellId: Short, spellLevel: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val destinationCellId = buf.readShort()
    val critical = buf.readByte()
    val silentCast = buf.readBoolean()
    val spellId = buf.readShort()
    val spellLevel = buf.readByte()

    create(actionId, sourceId, targetId, destinationCellId, critical, silentCast, spellId, spellLevel)
  }

}

object GameActionFightSpellCastMessage extends GameActionFightSpellCastMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean, spellId: Short, spellLevel: Byte) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean, spellId: Short, spellLevel: Byte) = MessageImpl(actionId, sourceId, targetId, destinationCellId, critical, silentCast, spellId, spellLevel)

  def apply(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean, spellId: Short, spellLevel: Byte) = create(actionId, sourceId, targetId, destinationCellId, critical, silentCast, spellId, spellLevel)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

