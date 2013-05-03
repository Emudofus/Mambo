




















// Generated on 05/03/2013 10:34:33
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightDispellableEffectMessage extends AbstractGameActionMessage {
  override val messageId = 6070

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightDispellableEffectMessage.messageId

    val effect: AbstractFightDispellableEffect.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(effect.typeId)
      effect.serialize(buf)
    }

  }

  protected def create(actionId: Short, sourceId: Int, effect: AbstractFightDispellableEffect.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val effect = types.get[AbstractFightDispellableEffect.TypeImpl](buf.readShort());

    create(actionId, sourceId, effect)
  }

}

object GameActionFightDispellableEffectMessage extends GameActionFightDispellableEffectMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, effect: AbstractFightDispellableEffect.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, effect: AbstractFightDispellableEffect.TypeImpl) = MessageImpl(actionId, sourceId, effect)

  def apply(actionId: Short, sourceId: Int, effect: AbstractFightDispellableEffect.TypeImpl) = create(actionId, sourceId, effect)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

