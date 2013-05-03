




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SetEnablePVPRequestMessage extends MessageDeserializer {
  val messageId = 1810

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SetEnablePVPRequestMessage.messageId

    val enable: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(enable)
    }

  }

  protected def create(enable: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val enable = buf.readBoolean()

    create(enable)
  }

}

object SetEnablePVPRequestMessage extends SetEnablePVPRequestMessage {
  case class MessageImpl(enable: Boolean) extends Message
  type Target = MessageImpl

  override def create(enable: Boolean) = MessageImpl(enable)

  def apply(enable: Boolean) = create(enable)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

