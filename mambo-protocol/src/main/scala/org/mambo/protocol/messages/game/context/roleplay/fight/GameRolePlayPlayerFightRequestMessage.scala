




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayPlayerFightRequestMessage extends MessageDeserializer {
  val messageId = 5731

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayPlayerFightRequestMessage.messageId

    val targetId: Int
    val targetCellId: Short
    val friendly: Boolean

    def serialize(buf: Buffer) {
      buf.writeInt(targetId)
      buf.writeShort(targetCellId)
      buf.writeBoolean(friendly)
    }

  }

  protected def create(targetId: Int, targetCellId: Short, friendly: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val targetId = buf.readInt()
    val targetCellId = buf.readShort()
    val friendly = buf.readBoolean()

    create(targetId, targetCellId, friendly)
  }

}

object GameRolePlayPlayerFightRequestMessage extends GameRolePlayPlayerFightRequestMessage {
  case class MessageImpl(targetId: Int, targetCellId: Short, friendly: Boolean) extends Message
  type Target = MessageImpl

  override def create(targetId: Int, targetCellId: Short, friendly: Boolean) = MessageImpl(targetId, targetCellId, friendly)

  def apply(targetId: Int, targetCellId: Short, friendly: Boolean) = create(targetId, targetCellId, friendly)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

