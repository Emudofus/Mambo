




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TextInformationMessage extends MessageDeserializer {
  val messageId = 780

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TextInformationMessage.messageId

    val msgType: Byte
    val msgId: Short
    val parameters: Seq[String]

    def serialize(buf: Buffer) {
      buf.writeByte(msgType)
      buf.writeShort(msgId)
      buf.writeUShort(parameters.length)
      for (entry <- parameters) {
        buf.writeString(entry)
      }
    }

  }

  protected def create(msgType: Byte, msgId: Short, parameters: Seq[String]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val msgType = buf.readByte()
    val msgId = buf.readShort()
    val parameters = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }

    create(msgType, msgId, parameters)
  }

}

object TextInformationMessage extends TextInformationMessage {
  case class MessageImpl(msgType: Byte, msgId: Short, parameters: Seq[String]) extends Message
  type Target = MessageImpl

  override def create(msgType: Byte, msgId: Short, parameters: Seq[String]) = MessageImpl(msgType, msgId, parameters)

  def apply(msgType: Byte, msgId: Short, parameters: Seq[String]) = create(msgType, msgId, parameters)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

