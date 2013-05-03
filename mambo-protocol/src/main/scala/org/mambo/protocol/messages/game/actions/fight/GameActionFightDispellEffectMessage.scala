




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightDispellEffectMessage extends GameActionFightDispellMessage {
  override val messageId = 6113

  protected trait Message extends GameActionFightDispellMessage.Message with Serializable {
    override val messageId = GameActionFightDispellEffectMessage.messageId

    val boostUID: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(boostUID)
    }

  }

  protected def create(actionId: Short, sourceId: Int, targetId: Int, boostUID: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()
    val boostUID = buf.readInt()

    create(actionId, sourceId, targetId, boostUID)
  }

}

object GameActionFightDispellEffectMessage extends GameActionFightDispellEffectMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, targetId: Int, boostUID: Int) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, targetId: Int, boostUID: Int) = MessageImpl(actionId, sourceId, targetId, boostUID)

  def apply(actionId: Short, sourceId: Int, targetId: Int, boostUID: Int) = create(actionId, sourceId, targetId, boostUID)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

