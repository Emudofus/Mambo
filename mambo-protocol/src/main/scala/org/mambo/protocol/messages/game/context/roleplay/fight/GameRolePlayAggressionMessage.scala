




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayAggressionMessage extends MessageDeserializer {
  val messageId = 6073

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayAggressionMessage.messageId

    val attackerId: Int
    val defenderId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(attackerId)
      buf.writeInt(defenderId)
    }

  }

  protected def create(attackerId: Int, defenderId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val attackerId = buf.readInt()
    val defenderId = buf.readInt()

    create(attackerId, defenderId)
  }

}

object GameRolePlayAggressionMessage extends GameRolePlayAggressionMessage {
  case class MessageImpl(attackerId: Int, defenderId: Int) extends Message
  type Target = MessageImpl

  override def create(attackerId: Int, defenderId: Int) = MessageImpl(attackerId, defenderId)

  def apply(attackerId: Int, defenderId: Int) = create(attackerId, defenderId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

