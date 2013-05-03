




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DebugHighlightCellsMessage extends MessageDeserializer {
  val messageId = 2001

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DebugHighlightCellsMessage.messageId

    val color: Int
    val cells: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeInt(color)
      buf.writeUShort(cells.length)
      for (entry <- cells) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(color: Int, cells: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val color = buf.readInt()
    val cells = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(color, cells)
  }

}

object DebugHighlightCellsMessage extends DebugHighlightCellsMessage {
  case class MessageImpl(color: Int, cells: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(color: Int, cells: Seq[Short]) = MessageImpl(color, cells)

  def apply(color: Int, cells: Seq[Short]) = create(color, cells)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

