




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AcquaintanceSearchMessage extends MessageDeserializer {
  val messageId = 6144

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AcquaintanceSearchMessage.messageId

    val nickname: String

    def serialize(buf: Buffer) {
      buf.writeString(nickname)
    }

  }

  protected def create(nickname: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val nickname = buf.readString()

    create(nickname)
  }

}

object AcquaintanceSearchMessage extends AcquaintanceSearchMessage {
  case class MessageImpl(nickname: String) extends Message
  type Target = MessageImpl

  override def create(nickname: String) = MessageImpl(nickname)

  def apply(nickname: String) = create(nickname)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

