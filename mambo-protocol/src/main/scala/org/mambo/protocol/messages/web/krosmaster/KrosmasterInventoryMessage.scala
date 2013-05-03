




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait KrosmasterInventoryMessage extends MessageDeserializer {
  val messageId = 6350

  protected trait Message extends BaseMessage with Serializable {
    val messageId = KrosmasterInventoryMessage.messageId

    val figures: Seq[KrosmasterFigure.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(figures.length)
      for (entry <- figures) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(figures: Seq[KrosmasterFigure.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val figures = {
      val builder = collection.immutable.Seq.newBuilder[KrosmasterFigure.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += KrosmasterFigure.deserialize(buf)
      }
      builder.result()
    }

    create(figures)
  }

}

object KrosmasterInventoryMessage extends KrosmasterInventoryMessage {
  case class MessageImpl(figures: Seq[KrosmasterFigure.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(figures: Seq[KrosmasterFigure.TypeImpl]) = MessageImpl(figures)

  def apply(figures: Seq[KrosmasterFigure.TypeImpl]) = create(figures)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

