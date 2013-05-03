




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait KrosmasterTransferMessage extends MessageDeserializer {
  val messageId = 6348

  protected trait Message extends BaseMessage with Serializable {
    val messageId = KrosmasterTransferMessage.messageId

    val uid: String
    val failure: Byte

    def serialize(buf: Buffer) {
      buf.writeString(uid)
      buf.writeByte(failure)
    }

  }

  protected def create(uid: String, failure: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val uid = buf.readString()
    val failure = buf.readByte()

    create(uid, failure)
  }

}

object KrosmasterTransferMessage extends KrosmasterTransferMessage {
  case class MessageImpl(uid: String, failure: Byte) extends Message
  type Target = MessageImpl

  override def create(uid: String, failure: Byte) = MessageImpl(uid, failure)

  def apply(uid: String, failure: Byte) = create(uid, failure)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

