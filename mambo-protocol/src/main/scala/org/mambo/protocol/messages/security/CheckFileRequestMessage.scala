




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CheckFileRequestMessage extends MessageDeserializer {
  val messageId = 6154

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CheckFileRequestMessage.messageId

    val filename: String
    val theType: Byte

    def serialize(buf: Buffer) {
      buf.writeString(filename)
      buf.writeByte(theType)
    }

  }

  protected def create(filename: String, theType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val filename = buf.readString()
    val theType = buf.readByte()

    create(filename, theType)
  }

}

object CheckFileRequestMessage extends CheckFileRequestMessage {
  case class MessageImpl(filename: String, theType: Byte) extends Message
  type Target = MessageImpl

  override def create(filename: String, theType: Byte) = MessageImpl(filename, theType)

  def apply(filename: String, theType: Byte) = create(filename, theType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

