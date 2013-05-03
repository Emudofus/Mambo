




















// Generated on 05/03/2013 10:34:30
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AdminQuietCommandMessage extends AdminCommandMessage {
  override val messageId = 5662

  protected trait Message extends AdminCommandMessage.Message with Serializable {
    override val messageId = AdminQuietCommandMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val content = buf.readString()

    create(content)
  }

}

object AdminQuietCommandMessage extends AdminQuietCommandMessage {
  case class MessageImpl(content: String) extends Message
  type Target = MessageImpl

  override def create(content: String) = MessageImpl(content)

  def apply(content: String) = create(content)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

