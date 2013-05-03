




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IgnoredDeleteRequestMessage extends MessageDeserializer {
  val messageId = 5680

  protected trait Message extends BaseMessage with Serializable {
    val messageId = IgnoredDeleteRequestMessage.messageId

    val name: String
    val session: Boolean

    def serialize(buf: Buffer) {
      buf.writeString(name)
      buf.writeBoolean(session)
    }

  }

  protected def create(name: String, session: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val name = buf.readString()
    val session = buf.readBoolean()

    create(name, session)
  }

}

object IgnoredDeleteRequestMessage extends IgnoredDeleteRequestMessage {
  case class MessageImpl(name: String, session: Boolean) extends Message
  type Target = MessageImpl

  override def create(name: String, session: Boolean) = MessageImpl(name, session)

  def apply(name: String, session: Boolean) = create(name, session)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

