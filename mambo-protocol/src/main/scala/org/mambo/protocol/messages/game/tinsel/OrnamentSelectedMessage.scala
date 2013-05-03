




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait OrnamentSelectedMessage extends MessageDeserializer {
  val messageId = 6369

  protected trait Message extends BaseMessage with Serializable {
    val messageId = OrnamentSelectedMessage.messageId

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

object OrnamentSelectedMessage extends OrnamentSelectedMessage {
  case class MessageImpl(ornamentId: Short) extends Message
  type Target = MessageImpl

  override def create(ornamentId: Short) = MessageImpl(ornamentId)

  def apply(ornamentId: Short) = create(ornamentId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

