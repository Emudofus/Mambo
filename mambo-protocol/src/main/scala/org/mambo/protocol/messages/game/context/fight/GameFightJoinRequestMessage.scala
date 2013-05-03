




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightJoinRequestMessage extends MessageDeserializer {
  val messageId = 701

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightJoinRequestMessage.messageId

    val fighterId: Int
    val fightId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(fighterId)
      buf.writeInt(fightId)
    }

  }

  protected def create(fighterId: Int, fightId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fighterId = buf.readInt()
    val fightId = buf.readInt()

    create(fighterId, fightId)
  }

}

object GameFightJoinRequestMessage extends GameFightJoinRequestMessage {
  case class MessageImpl(fighterId: Int, fightId: Int) extends Message
  type Target = MessageImpl

  override def create(fighterId: Int, fightId: Int) = MessageImpl(fighterId, fightId)

  def apply(fighterId: Int, fightId: Int) = create(fighterId, fightId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

