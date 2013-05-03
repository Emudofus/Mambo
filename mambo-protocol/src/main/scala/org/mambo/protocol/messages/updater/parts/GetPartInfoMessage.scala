




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GetPartInfoMessage extends MessageDeserializer {
  val messageId = 1506

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GetPartInfoMessage.messageId

    val id: String

    def serialize(buf: Buffer) {
      buf.writeString(id)
    }

  }

  protected def create(id: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readString()

    create(id)
  }

}

object GetPartInfoMessage extends GetPartInfoMessage {
  case class MessageImpl(id: String) extends Message
  type Target = MessageImpl

  override def create(id: String) = MessageImpl(id)

  def apply(id: String) = create(id)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

