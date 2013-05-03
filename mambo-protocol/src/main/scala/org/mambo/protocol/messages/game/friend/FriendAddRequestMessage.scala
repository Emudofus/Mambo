




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait FriendAddRequestMessage extends MessageDeserializer {
  val messageId = 4004

  protected trait Message extends BaseMessage with Serializable {
    val messageId = FriendAddRequestMessage.messageId

    val name: String

    def serialize(buf: Buffer) {
      buf.writeString(name)
    }

  }

  protected def create(name: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val name = buf.readString()

    create(name)
  }

}

object FriendAddRequestMessage extends FriendAddRequestMessage {
  case class MessageImpl(name: String) extends Message
  type Target = MessageImpl

  override def create(name: String) = MessageImpl(name)

  def apply(name: String) = create(name)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

