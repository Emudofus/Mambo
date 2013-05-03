




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightNewRoundMessage extends MessageDeserializer {
  val messageId = 6239

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightNewRoundMessage.messageId

    val roundNumber: Int

    def serialize(buf: Buffer) {
      buf.writeInt(roundNumber)
    }

  }

  protected def create(roundNumber: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val roundNumber = buf.readInt()

    create(roundNumber)
  }

}

object GameFightNewRoundMessage extends GameFightNewRoundMessage {
  case class MessageImpl(roundNumber: Int) extends Message
  type Target = MessageImpl

  override def create(roundNumber: Int) = MessageImpl(roundNumber)

  def apply(roundNumber: Int) = create(roundNumber)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

