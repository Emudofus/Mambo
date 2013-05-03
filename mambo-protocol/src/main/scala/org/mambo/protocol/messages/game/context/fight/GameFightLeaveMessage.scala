




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightLeaveMessage extends MessageDeserializer {
  val messageId = 721

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightLeaveMessage.messageId

    val charId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(charId)
    }

  }

  protected def create(charId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val charId = buf.readInt()

    create(charId)
  }

}

object GameFightLeaveMessage extends GameFightLeaveMessage {
  case class MessageImpl(charId: Int) extends Message
  type Target = MessageImpl

  override def create(charId: Int) = MessageImpl(charId)

  def apply(charId: Int) = create(charId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

