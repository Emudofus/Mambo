




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AuthenticationTicketRefusedMessage extends MessageDeserializer {
  val messageId = 112

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AuthenticationTicketRefusedMessage.messageId


    def serialize(buf: Buffer) {
    }

  }

  protected def create(): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {

    create()
  }

}

object AuthenticationTicketRefusedMessage extends AuthenticationTicketRefusedMessage {
  case class MessageImpl() extends Message
  type Target = MessageImpl

  override def create() = MessageImpl()

  def apply() = create()
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

