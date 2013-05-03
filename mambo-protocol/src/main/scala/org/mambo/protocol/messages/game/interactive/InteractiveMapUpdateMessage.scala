




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InteractiveMapUpdateMessage extends MessageDeserializer {
  val messageId = 5002

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InteractiveMapUpdateMessage.messageId

    val interactiveElements: Seq[InteractiveElement.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(interactiveElements.length)
      for (entry <- interactiveElements) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(interactiveElements: Seq[InteractiveElement.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val interactiveElements = {
      val builder = collection.immutable.Seq.newBuilder[InteractiveElement.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[InteractiveElement.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(interactiveElements)
  }

}

object InteractiveMapUpdateMessage extends InteractiveMapUpdateMessage {
  case class MessageImpl(interactiveElements: Seq[InteractiveElement.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(interactiveElements: Seq[InteractiveElement.TypeImpl]) = MessageImpl(interactiveElements)

  def apply(interactiveElements: Seq[InteractiveElement.TypeImpl]) = create(interactiveElements)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

