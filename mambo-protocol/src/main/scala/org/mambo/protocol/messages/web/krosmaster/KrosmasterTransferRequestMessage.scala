




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait KrosmasterTransferRequestMessage extends MessageDeserializer {
  val messageId = 6349

  protected trait Message extends BaseMessage with Serializable {
    val messageId = KrosmasterTransferRequestMessage.messageId

    val uid: String

    def serialize(buf: Buffer) {
      buf.writeString(uid)
    }

  }

  protected def create(uid: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val uid = buf.readString()

    create(uid)
  }

}

object KrosmasterTransferRequestMessage extends KrosmasterTransferRequestMessage {
  case class MessageImpl(uid: String) extends Message
  type Target = MessageImpl

  override def create(uid: String) = MessageImpl(uid)

  def apply(uid: String) = create(uid)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

