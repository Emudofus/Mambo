




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightSpellCooldownVariationMessage extends AbstractGameActionMessage {
  override val messageId = 6219

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightSpellCooldownVariationMessage.messageId

    val targetId: Int
    val spellId: Int
    val value: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeInt(spellId)
      buf.writeShort(value)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, spellId: Int, value: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val spellId = buf.readInt()
    val value = buf.readShort()

    create(actionId, sourceId, targetId, spellId, value)
  }

}

object GameActionFightSpellCooldownVariationMessage extends GameActionFightSpellCooldownVariationMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, spellId: Int, value: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, spellId: Int, value: Short) = MessageImpl(actionId, sourceId, targetId, spellId, value)

  def apply(actionId: Short, sourceId: Int, targetId: Int, spellId: Int, value: Short) = create(actionId, sourceId, targetId, spellId, value)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

