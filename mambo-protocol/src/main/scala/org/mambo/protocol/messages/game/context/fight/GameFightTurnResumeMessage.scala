




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightTurnResumeMessage extends GameFightTurnStartMessage {
  override val messageId = 6307

  protected trait Message extends GameFightTurnStartMessage.Message with Serializable {
    override val messageId = GameFightTurnResumeMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val waitTime = buf.readInt()

    create(id, waitTime)
  }

}

object GameFightTurnResumeMessage extends GameFightTurnResumeMessage {
  case class MessageImpl(id: Int, waitTime: Int) extends Message
  type Target = MessageImpl

  override def create(id: Int, waitTime: Int) = MessageImpl(id, waitTime)

  def apply(id: Int, waitTime: Int) = create(id, waitTime)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

