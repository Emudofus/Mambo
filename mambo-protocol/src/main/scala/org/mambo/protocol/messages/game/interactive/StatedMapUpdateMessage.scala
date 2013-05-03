




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StatedMapUpdateMessage extends MessageDeserializer {
  val messageId = 5716

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StatedMapUpdateMessage.messageId

    val statedElements: Seq[StatedElement.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(statedElements.length)
      for (entry <- statedElements) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(statedElements: Seq[StatedElement.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val statedElements = {
      val builder = collection.immutable.Seq.newBuilder[StatedElement.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += StatedElement.deserialize(buf)
      }
      builder.result()
    }

    create(statedElements)
  }

}

object StatedMapUpdateMessage extends StatedMapUpdateMessage {
  case class MessageImpl(statedElements: Seq[StatedElement.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(statedElements: Seq[StatedElement.TypeImpl]) = MessageImpl(statedElements)

  def apply(statedElements: Seq[StatedElement.TypeImpl]) = create(statedElements)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

