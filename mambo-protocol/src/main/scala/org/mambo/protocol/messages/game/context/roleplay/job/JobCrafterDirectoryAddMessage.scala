




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobCrafterDirectoryAddMessage extends MessageDeserializer {
  val messageId = 5651

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobCrafterDirectoryAddMessage.messageId

    val listEntry: JobCrafterDirectoryListEntry.TypeImpl

    def serialize(buf: Buffer) {
      listEntry.serialize(buf)
    }

  }

  protected def create(listEntry: JobCrafterDirectoryListEntry.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val listEntry = JobCrafterDirectoryListEntry.deserialize(buf)

    create(listEntry)
  }

}

object JobCrafterDirectoryAddMessage extends JobCrafterDirectoryAddMessage {
  case class MessageImpl(listEntry: JobCrafterDirectoryListEntry.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(listEntry: JobCrafterDirectoryListEntry.TypeImpl) = MessageImpl(listEntry)

  def apply(listEntry: JobCrafterDirectoryListEntry.TypeImpl) = create(listEntry)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

