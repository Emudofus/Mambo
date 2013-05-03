




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayArenaRegistrationStatusMessage extends MessageDeserializer {
  val messageId = 6284

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayArenaRegistrationStatusMessage.messageId

    val registered: Boolean
    val step: Byte
    val battleMode: Int

    def serialize(buf: Buffer) {
      buf.writeBoolean(registered)
      buf.writeByte(step)
      buf.writeInt(battleMode)
    }

  }

  protected def create(registered: Boolean, step: Byte, battleMode: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val registered = buf.readBoolean()
    val step = buf.readByte()
    val battleMode = buf.readInt()

    create(registered, step, battleMode)
  }

}

object GameRolePlayArenaRegistrationStatusMessage extends GameRolePlayArenaRegistrationStatusMessage {
  case class MessageImpl(registered: Boolean, step: Byte, battleMode: Int) extends Message
  type Target = MessageImpl

  override def create(registered: Boolean, step: Byte, battleMode: Int) = MessageImpl(registered, step, battleMode)

  def apply(registered: Boolean, step: Byte, battleMode: Int) = create(registered, step, battleMode)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

