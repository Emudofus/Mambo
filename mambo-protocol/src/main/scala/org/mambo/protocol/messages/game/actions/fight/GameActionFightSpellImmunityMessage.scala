




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightSpellImmunityMessage extends AbstractGameActionMessage {
  override val messageId = 6221

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightSpellImmunityMessage.messageId

    val targetId: Int
    val spellId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(targetId)
      buf.writeInt(spellId)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, spellId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val spellId = buf.readInt()

    create(actionId, sourceId, targetId, spellId)
  }

}

object GameActionFightSpellImmunityMessage extends GameActionFightSpellImmunityMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, spellId: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, spellId: Int) = MessageImpl(actionId, sourceId, targetId, spellId)

  def apply(actionId: Short, sourceId: Int, targetId: Int, spellId: Int) = create(actionId, sourceId, targetId, spellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

