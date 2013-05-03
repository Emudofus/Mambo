




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LockableUseCodeMessage extends MessageDeserializer {
  val messageId = 5667

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LockableUseCodeMessage.messageId

    val code: String

    def serialize(buf: Buffer) {
      buf.writeString(code)
    }

  }

  protected def create(code: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val code = buf.readString()

    create(code)
  }

}

object LockableUseCodeMessage extends LockableUseCodeMessage {
  case class MessageImpl(code: String) extends Message
  type Target = MessageImpl

  override def create(code: String) = MessageImpl(code)

  def apply(code: String) = create(code)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

