




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightSummonMessage extends AbstractGameActionMessage {
  override val messageId = 5825

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightSummonMessage.messageId

    val summon: GameFightFighterInformations.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(summon.typeId)
      summon.serialize(buf)
    }

  }

  protected def create(actionId: Short, sourceId: Int, summon: GameFightFighterInformations.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val summon = types.get[GameFightFighterInformations.TypeImpl](buf.readShort());

    create(actionId, sourceId, summon)
  }

}

object GameActionFightSummonMessage extends GameActionFightSummonMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, summon: GameFightFighterInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, summon: GameFightFighterInformations.TypeImpl) = MessageImpl(actionId, sourceId, summon)

  def apply(actionId: Short, sourceId: Int, summon: GameFightFighterInformations.TypeImpl) = create(actionId, sourceId, summon)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

