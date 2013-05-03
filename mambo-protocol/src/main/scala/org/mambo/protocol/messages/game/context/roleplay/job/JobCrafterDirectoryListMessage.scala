




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobCrafterDirectoryListMessage extends MessageDeserializer {
  val messageId = 6046

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobCrafterDirectoryListMessage.messageId

    val listEntries: Seq[JobCrafterDirectoryListEntry.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(listEntries.length)
      for (entry <- listEntries) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(listEntries: Seq[JobCrafterDirectoryListEntry.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val listEntries = {
      val builder = collection.immutable.Seq.newBuilder[JobCrafterDirectoryListEntry.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += JobCrafterDirectoryListEntry.deserialize(buf)
      }
      builder.result()
    }

    create(listEntries)
  }

}

object JobCrafterDirectoryListMessage extends JobCrafterDirectoryListMessage {
  case class MessageImpl(listEntries: Seq[JobCrafterDirectoryListEntry.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(listEntries: Seq[JobCrafterDirectoryListEntry.TypeImpl]) = MessageImpl(listEntries)

  def apply(listEntries: Seq[JobCrafterDirectoryListEntry.TypeImpl]) = create(listEntries)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

