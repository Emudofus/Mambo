




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightTriggerEffectMessage extends GameActionFightDispellEffectMessage {
  override val messageId = 6147

  protected trait Message extends GameActionFightDispellEffectMessage.Message with Serializable {
    override val messageId = GameActionFightTriggerEffectMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val boostUID = buf.readInt()

    create(actionId, sourceId, targetId, boostUID)
  }

}

object GameActionFightTriggerEffectMessage extends GameActionFightTriggerEffectMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, boostUID: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, boostUID: Int) = MessageImpl(actionId, sourceId, targetId, boostUID)

  def apply(actionId: Short, sourceId: Int, targetId: Int, boostUID: Int) = create(actionId, sourceId, targetId, boostUID)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

