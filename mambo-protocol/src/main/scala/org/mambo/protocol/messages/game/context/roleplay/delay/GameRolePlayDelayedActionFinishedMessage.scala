




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayDelayedActionFinishedMessage extends MessageDeserializer {
  val messageId = 6150

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayDelayedActionFinishedMessage.messageId

    val delayedCharacterId: Int
    val delayTypeId: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(delayedCharacterId)
      buf.writeByte(delayTypeId)
    }

  }

  protected def create(delayedCharacterId: Int, delayTypeId: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val delayedCharacterId = buf.readInt()
    val delayTypeId = buf.readByte()

    create(delayedCharacterId, delayTypeId)
  }

}

object GameRolePlayDelayedActionFinishedMessage extends GameRolePlayDelayedActionFinishedMessage {
  case class MessageImpl(delayedCharacterId: Int, delayTypeId: Byte) extends Message
  type Target = MessageImpl

  override def create(delayedCharacterId: Int, delayTypeId: Byte) = MessageImpl(delayedCharacterId, delayTypeId)

  def apply(delayedCharacterId: Int, delayTypeId: Byte) = create(delayedCharacterId, delayTypeId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

