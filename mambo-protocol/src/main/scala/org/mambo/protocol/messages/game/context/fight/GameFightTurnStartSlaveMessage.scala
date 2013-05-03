




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightTurnStartSlaveMessage extends GameFightTurnStartMessage {
  override val messageId = 6213

  protected trait Message extends GameFightTurnStartMessage.Message with Serializable {
    override val messageId = GameFightTurnStartSlaveMessage.messageId

    val idSummoner: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(idSummoner)
    }

  }

  protected def create(id: Int, waitTime: Int, idSummoner: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val waitTime = buf.readInt()
    val idSummoner = buf.readInt()

    create(id, waitTime, idSummoner)
  }

}

object GameFightTurnStartSlaveMessage extends GameFightTurnStartSlaveMessage {
  case class MessageImpl(id: Int, waitTime: Int, idSummoner: Int) extends Message
  type Target = MessageImpl

  override def create(id: Int, waitTime: Int, idSummoner: Int) = MessageImpl(id, waitTime, idSummoner)

  def apply(id: Int, waitTime: Int, idSummoner: Int) = create(id, waitTime, idSummoner)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

