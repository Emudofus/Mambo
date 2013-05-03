




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AuthenticationTicketMessage extends MessageDeserializer {
  val messageId = 110

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AuthenticationTicketMessage.messageId

    val lang: String
    val ticket: String

    def serialize(buf: Buffer) {
      buf.writeString(lang)
      buf.writeString(ticket)
    }

  }

  protected def create(lang: String, ticket: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val lang = buf.readString()
    val ticket = buf.readString()

    create(lang, ticket)
  }

}

object AuthenticationTicketMessage extends AuthenticationTicketMessage {
  case class MessageImpl(lang: String, ticket: String) extends Message
  type Target = MessageImpl

  override def create(lang: String, ticket: String) = MessageImpl(lang, ticket)

  def apply(lang: String, ticket: String) = create(lang, ticket)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

