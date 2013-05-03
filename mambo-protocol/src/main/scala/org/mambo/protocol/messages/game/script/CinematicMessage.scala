




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CinematicMessage extends MessageDeserializer {
  val messageId = 6053

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CinematicMessage.messageId

    val cinematicId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(cinematicId)
    }

  }

  protected def create(cinematicId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cinematicId = buf.readShort()

    create(cinematicId)
  }

}

object CinematicMessage extends CinematicMessage {
  case class MessageImpl(cinematicId: Short) extends Message
  type Target = MessageImpl

  override def create(cinematicId: Short) = MessageImpl(cinematicId)

  def apply(cinematicId: Short) = create(cinematicId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

