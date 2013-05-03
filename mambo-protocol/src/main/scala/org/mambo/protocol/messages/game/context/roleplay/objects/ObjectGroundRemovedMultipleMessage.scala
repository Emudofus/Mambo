




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectGroundRemovedMultipleMessage extends MessageDeserializer {
  val messageId = 5944

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectGroundRemovedMultipleMessage.messageId

    val cells: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(cells.length)
      for (entry <- cells) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(cells: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cells = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(cells)
  }

}

object ObjectGroundRemovedMultipleMessage extends ObjectGroundRemovedMultipleMessage {
  case class MessageImpl(cells: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(cells: Seq[Short]) = MessageImpl(cells)

  def apply(cells: Seq[Short]) = create(cells)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

