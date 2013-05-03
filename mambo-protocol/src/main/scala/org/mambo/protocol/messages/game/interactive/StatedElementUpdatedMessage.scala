




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StatedElementUpdatedMessage extends MessageDeserializer {
  val messageId = 5709

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StatedElementUpdatedMessage.messageId

    val statedElement: StatedElement.TypeImpl

    def serialize(buf: Buffer) {
      statedElement.serialize(buf)
    }

  }

  protected def create(statedElement: StatedElement.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val statedElement = StatedElement.deserialize(buf)

    create(statedElement)
  }

}

object StatedElementUpdatedMessage extends StatedElementUpdatedMessage {
  case class MessageImpl(statedElement: StatedElement.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(statedElement: StatedElement.TypeImpl) = MessageImpl(statedElement)

  def apply(statedElement: StatedElement.TypeImpl) = create(statedElement)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

