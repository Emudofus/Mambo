




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TrustStatusMessage extends MessageDeserializer {
  val messageId = 6267

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TrustStatusMessage.messageId

    val trusted: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(trusted)
    }

  }

  protected def create(trusted: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val trusted = buf.readBoolean()

    create(trusted)
  }

}

object TrustStatusMessage extends TrustStatusMessage {
  case class MessageImpl(trusted: Boolean) extends Message
  type Target = MessageImpl

  override def create(trusted: Boolean) = MessageImpl(trusted)

  def apply(trusted: Boolean) = create(trusted)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

