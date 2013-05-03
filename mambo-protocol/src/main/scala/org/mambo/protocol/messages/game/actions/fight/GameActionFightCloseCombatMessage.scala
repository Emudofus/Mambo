




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightCloseCombatMessage extends AbstractGameActionFightTargetedAbilityMessage {
  override val messageId = 6116

  protected trait Message extends AbstractGameActionFightTargetedAbilityMessage.Message with Serializable {
    override val messageId = GameActionFightCloseCombatMessage.messageId

    val weaponGenericId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(weaponGenericId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean, weaponGenericId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val destinationCellId = buf.readShort()
    val critical = buf.readByte()
    val silentCast = buf.readBoolean()
    val weaponGenericId = buf.readInt()

    create(actionId, sourceId, targetId, destinationCellId, critical, silentCast, weaponGenericId)
  }

}

object GameActionFightCloseCombatMessage extends GameActionFightCloseCombatMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean, weaponGenericId: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean, weaponGenericId: Int) = MessageImpl(actionId, sourceId, targetId, destinationCellId, critical, silentCast, weaponGenericId)

  def apply(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean, weaponGenericId: Int) = create(actionId, sourceId, targetId, destinationCellId, critical, silentCast, weaponGenericId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

