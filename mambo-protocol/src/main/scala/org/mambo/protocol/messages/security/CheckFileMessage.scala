




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CheckFileMessage extends MessageDeserializer {
  val messageId = 6156

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CheckFileMessage.messageId

    val filenameHash: String
    val theType: Byte
    val value: String

    def serialize(buf: Buffer) {
      buf.writeString(filenameHash)
      buf.writeByte(theType)
      buf.writeString(value)
    }

  }

  protected def create(filenameHash: String, theType: Byte, value: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val filenameHash = buf.readString()
    val theType = buf.readByte()
    val value = buf.readString()

    create(filenameHash, theType, value)
  }

}

object CheckFileMessage extends CheckFileMessage {
  case class MessageImpl(filenameHash: String, theType: Byte, value: String) extends Message
  type Target = MessageImpl

  override def create(filenameHash: String, theType: Byte, value: String) = MessageImpl(filenameHash, theType, value)

  def apply(filenameHash: String, theType: Byte, value: String) = create(filenameHash, theType, value)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

