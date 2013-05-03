




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayArenaRegisterMessage extends MessageDeserializer {
  val messageId = 6280

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayArenaRegisterMessage.messageId

    val battleMode: Int

    def serialize(buf: Buffer) {
      buf.writeInt(battleMode)
    }

  }

  protected def create(battleMode: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val battleMode = buf.readInt()

    create(battleMode)
  }

}

object GameRolePlayArenaRegisterMessage extends GameRolePlayArenaRegisterMessage {
  case class MessageImpl(battleMode: Int) extends Message
  type Target = MessageImpl

  override def create(battleMode: Int) = MessageImpl(battleMode)

  def apply(battleMode: Int) = create(battleMode)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

