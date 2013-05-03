




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChallengeFightJoinRefusedMessage extends MessageDeserializer {
  val messageId = 5908

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChallengeFightJoinRefusedMessage.messageId

    val playerId: Int
    val reason: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(playerId)
      buf.writeByte(reason)
    }

  }

  protected def create(playerId: Int, reason: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playerId = buf.readInt()
    val reason = buf.readByte()

    create(playerId, reason)
  }

}

object ChallengeFightJoinRefusedMessage extends ChallengeFightJoinRefusedMessage {
  case class MessageImpl(playerId: Int, reason: Byte) extends Message
  type Target = MessageImpl

  override def create(playerId: Int, reason: Byte) = MessageImpl(playerId, reason)

  def apply(playerId: Int, reason: Byte) = create(playerId, reason)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

