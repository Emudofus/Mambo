




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightTriggerGlyphTrapMessage extends AbstractGameActionMessage {
  override val messageId = 5741

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightTriggerGlyphTrapMessage.messageId

    val markId: Short
    val triggeringCharacterId: Int
    val triggeredSpellId: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(markId)
      buf.writeInt(triggeringCharacterId)
      buf.writeShort(triggeredSpellId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, markId: Short, triggeringCharacterId: Int, triggeredSpellId: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val markId = buf.readShort()
    val triggeringCharacterId = buf.readInt()
    val triggeredSpellId = buf.readShort()

    create(actionId, sourceId, markId, triggeringCharacterId, triggeredSpellId)
  }

}

object GameActionFightTriggerGlyphTrapMessage extends GameActionFightTriggerGlyphTrapMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, markId: Short, triggeringCharacterId: Int, triggeredSpellId: Short) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, markId: Short, triggeringCharacterId: Int, triggeredSpellId: Short) = MessageImpl(actionId, sourceId, markId, triggeringCharacterId, triggeredSpellId)

  def apply(actionId: Short, sourceId: Int, markId: Short, triggeringCharacterId: Int, triggeredSpellId: Short) = create(actionId, sourceId, markId, triggeringCharacterId, triggeredSpellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

