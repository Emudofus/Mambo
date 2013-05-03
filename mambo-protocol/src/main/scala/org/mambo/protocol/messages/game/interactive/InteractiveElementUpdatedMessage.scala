




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InteractiveElementUpdatedMessage extends MessageDeserializer {
  val messageId = 5708

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InteractiveElementUpdatedMessage.messageId

    val interactiveElement: InteractiveElement.TypeImpl

    def serialize(buf: Buffer) {
      interactiveElement.serialize(buf)
    }

  }

  protected def create(interactiveElement: InteractiveElement.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val interactiveElement = InteractiveElement.deserialize(buf)

    create(interactiveElement)
  }

}

object InteractiveElementUpdatedMessage extends InteractiveElementUpdatedMessage {
  case class MessageImpl(interactiveElement: InteractiveElement.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(interactiveElement: InteractiveElement.TypeImpl) = MessageImpl(interactiveElement)

  def apply(interactiveElement: InteractiveElement.TypeImpl) = create(interactiveElement)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

