




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait OrnamentGainedMessage extends MessageDeserializer {
  val messageId = 6368

  protected trait Message extends BaseMessage with Serializable {
    val messageId = OrnamentGainedMessage.messageId

    val ornamentId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(ornamentId)
    }

  }

  protected def create(ornamentId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val ornamentId = buf.readShort()

    create(ornamentId)
  }

}

object OrnamentGainedMessage extends OrnamentGainedMessage {
  case class MessageImpl(ornamentId: Short) extends Message
  type Target = MessageImpl

  override def create(ornamentId: Short) = MessageImpl(ornamentId)

  def apply(ornamentId: Short) = create(ornamentId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

