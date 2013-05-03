




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismWorldInformationRequestMessage extends MessageDeserializer {
  val messageId = 5985

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismWorldInformationRequestMessage.messageId

    val join: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(join)
    }

  }

  protected def create(join: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val join = buf.readBoolean()

    create(join)
  }

}

object PrismWorldInformationRequestMessage extends PrismWorldInformationRequestMessage {
  case class MessageImpl(join: Boolean) extends Message
  type Target = MessageImpl

  override def create(join: Boolean) = MessageImpl(join)

  def apply(join: Boolean) = create(join)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

