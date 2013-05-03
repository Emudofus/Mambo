




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DocumentReadingBeginMessage extends MessageDeserializer {
  val messageId = 5675

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DocumentReadingBeginMessage.messageId

    val documentId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(documentId)
    }

  }

  protected def create(documentId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val documentId = buf.readShort()

    create(documentId)
  }

}

object DocumentReadingBeginMessage extends DocumentReadingBeginMessage {
  case class MessageImpl(documentId: Short) extends Message
  type Target = MessageImpl

  override def create(documentId: Short) = MessageImpl(documentId)

  def apply(documentId: Short) = create(documentId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

