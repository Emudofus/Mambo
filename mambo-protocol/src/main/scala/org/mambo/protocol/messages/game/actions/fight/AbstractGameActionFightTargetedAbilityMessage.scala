




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AbstractGameActionFightTargetedAbilityMessage extends AbstractGameActionMessage {
  override val messageId = 6118

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = AbstractGameActionFightTargetedAbilityMessage.messageId

    val targetId: Int
    val destinationCellId: Short
    val critical: Byte
    val silentCast: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeShort(destinationCellId)
      buf.writeByte(critical)
      buf.writeBoolean(silentCast)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val destinationCellId = buf.readShort()
    val critical = buf.readByte()
    val silentCast = buf.readBoolean()

    create(actionId, sourceId, targetId, destinationCellId, critical, silentCast)
  }

}

object AbstractGameActionFightTargetedAbilityMessage extends AbstractGameActionFightTargetedAbilityMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean) = MessageImpl(actionId, sourceId, targetId, destinationCellId, critical, silentCast)

  def apply(actionId: Short, sourceId: Int, targetId: Int, destinationCellId: Short, critical: Byte, silentCast: Boolean) = create(actionId, sourceId, targetId, destinationCellId, critical, silentCast)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

