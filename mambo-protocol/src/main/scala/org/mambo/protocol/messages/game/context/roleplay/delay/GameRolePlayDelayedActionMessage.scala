




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayDelayedActionMessage extends MessageDeserializer {
  val messageId = 6153

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayDelayedActionMessage.messageId

    val delayedCharacterId: Int
    val delayTypeId: Byte
    val delayDuration: Int

    def serialize(buf: Buffer) {
      buf.writeInt(delayedCharacterId)
      buf.writeByte(delayTypeId)
      buf.writeInt(delayDuration)
    }

  }

  protected def create(delayedCharacterId: Int, delayTypeId: Byte, delayDuration: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val delayedCharacterId = buf.readInt()
    val delayTypeId = buf.readByte()
    val delayDuration = buf.readInt()

    create(delayedCharacterId, delayTypeId, delayDuration)
  }

}

object GameRolePlayDelayedActionMessage extends GameRolePlayDelayedActionMessage {
  case class MessageImpl(delayedCharacterId: Int, delayTypeId: Byte, delayDuration: Int) extends Message
  type Target = MessageImpl

  override def create(delayedCharacterId: Int, delayTypeId: Byte, delayDuration: Int) = MessageImpl(delayedCharacterId, delayTypeId, delayDuration)

  def apply(delayedCharacterId: Int, delayTypeId: Byte, delayDuration: Int) = create(delayedCharacterId, delayTypeId, delayDuration)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

