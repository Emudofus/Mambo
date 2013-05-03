




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectGroundListAddedMessage extends MessageDeserializer {
  val messageId = 5925

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectGroundListAddedMessage.messageId

    val cells: Seq[Short]
    val referenceIds: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(cells.length)
      for (entry <- cells) {
        buf.writeShort(entry)
      }
      buf.writeUShort(referenceIds.length)
      for (entry <- referenceIds) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(cells: Seq[Short], referenceIds: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val cells = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val referenceIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(cells, referenceIds)
  }

}

object ObjectGroundListAddedMessage extends ObjectGroundListAddedMessage {
  case class MessageImpl(cells: Seq[Short], referenceIds: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(cells: Seq[Short], referenceIds: Seq[Int]) = MessageImpl(cells, referenceIds)

  def apply(cells: Seq[Short], referenceIds: Seq[Int]) = create(cells, referenceIds)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

