




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicWhoIsNoMatchMessage extends MessageDeserializer {
  val messageId = 179

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicWhoIsNoMatchMessage.messageId

    val search: String

    def serialize(buf: Buffer) {
      buf.writeString(search)
    }

  }

  protected def create(search: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val search = buf.readString()

    create(search)
  }

}

object BasicWhoIsNoMatchMessage extends BasicWhoIsNoMatchMessage {
  case class MessageImpl(search: String) extends Message
  type Target = MessageImpl

  override def create(search: String) = MessageImpl(search)

  def apply(search: String) = create(search)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

