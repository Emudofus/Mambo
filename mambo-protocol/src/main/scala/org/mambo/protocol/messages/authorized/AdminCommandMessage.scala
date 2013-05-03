




















// Generated on 05/03/2013 10:34:29
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AdminCommandMessage extends MessageDeserializer {
  val messageId = 76

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AdminCommandMessage.messageId

    val content: String

    def serialize(buf: Buffer) {
      buf.writeString(content)
    }

  }

  protected def create(content: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val content = buf.readString()

    create(content)
  }

}

object AdminCommandMessage extends AdminCommandMessage {
  case class MessageImpl(content: String) extends Message
  type Target = MessageImpl

  override def create(content: String) = MessageImpl(content)

  def apply(content: String) = create(content)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

