




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait FriendDeleteResultMessage extends MessageDeserializer {
  val messageId = 5601

  protected trait Message extends BaseMessage with Serializable {
    val messageId = FriendDeleteResultMessage.messageId

    val success: Boolean
    val name: String

    def serialize(buf: Buffer) {
      buf.writeBoolean(success)
      buf.writeString(name)
    }

  }

  protected def create(success: Boolean, name: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val success = buf.readBoolean()
    val name = buf.readString()

    create(success, name)
  }

}

object FriendDeleteResultMessage extends FriendDeleteResultMessage {
  case class MessageImpl(success: Boolean, name: String) extends Message
  type Target = MessageImpl

  override def create(success: Boolean, name: String) = MessageImpl(success, name)

  def apply(success: Boolean, name: String) = create(success, name)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

