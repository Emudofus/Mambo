




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightTurnStartMessage extends MessageDeserializer {
  val messageId = 714

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightTurnStartMessage.messageId

    val id: Int
    val waitTime: Int

    def serialize(buf: Buffer) {
      buf.writeInt(id)
      buf.writeInt(waitTime)
    }

  }

  protected def create(id: Int, waitTime: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val waitTime = buf.readInt()

    create(id, waitTime)
  }

}

object GameFightTurnStartMessage extends GameFightTurnStartMessage {
  case class MessageImpl(id: Int, waitTime: Int) extends Message
  type Target = MessageImpl

  override def create(id: Int, waitTime: Int) = MessageImpl(id, waitTime)

  def apply(id: Int, waitTime: Int) = create(id, waitTime)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

