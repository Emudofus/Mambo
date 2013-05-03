




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayFightRequestCanceledMessage extends MessageDeserializer {
  val messageId = 5822

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayFightRequestCanceledMessage.messageId

    val fightId: Int
    val sourceId: Int
    val targetId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
      buf.writeInt(sourceId)
      buf.writeInt(targetId)
    }

  }

  protected def create(fightId: Int, sourceId: Int, targetId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()
    val sourceId = buf.readInt()
    val targetId = buf.readInt()

    create(fightId, sourceId, targetId)
  }

}

object GameRolePlayFightRequestCanceledMessage extends GameRolePlayFightRequestCanceledMessage {
  case class MessageImpl(fightId: Int, sourceId: Int, targetId: Int) extends Message
  type Target = MessageImpl

  override def create(fightId: Int, sourceId: Int, targetId: Int) = MessageImpl(fightId, sourceId, targetId)

  def apply(fightId: Int, sourceId: Int, targetId: Int) = create(fightId, sourceId, targetId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

