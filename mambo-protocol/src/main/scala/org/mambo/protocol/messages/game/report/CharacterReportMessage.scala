




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterReportMessage extends MessageDeserializer {
  val messageId = 6079

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterReportMessage.messageId

    val reportedId: UInt
    val reason: Byte

    def serialize(buf: Buffer) {
      buf.writeUInt(reportedId)
      buf.writeByte(reason)
    }

  }

  protected def create(reportedId: UInt, reason: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val reportedId = buf.readUInt()
    val reason = buf.readByte()

    create(reportedId, reason)
  }

}

object CharacterReportMessage extends CharacterReportMessage {
  case class MessageImpl(reportedId: UInt, reason: Byte) extends Message
  type Target = MessageImpl

  override def create(reportedId: UInt, reason: Byte) = MessageImpl(reportedId, reason)

  def apply(reportedId: UInt, reason: Byte) = create(reportedId, reason)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

