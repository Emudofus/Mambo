




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobDescriptionMessage extends MessageDeserializer {
  val messageId = 5655

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobDescriptionMessage.messageId

    val jobsDescription: Seq[JobDescription.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(jobsDescription.length)
      for (entry <- jobsDescription) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(jobsDescription: Seq[JobDescription.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val jobsDescription = {
      val builder = collection.immutable.Seq.newBuilder[JobDescription.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += JobDescription.deserialize(buf)
      }
      builder.result()
    }

    create(jobsDescription)
  }

}

object JobDescriptionMessage extends JobDescriptionMessage {
  case class MessageImpl(jobsDescription: Seq[JobDescription.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(jobsDescription: Seq[JobDescription.TypeImpl]) = MessageImpl(jobsDescription)

  def apply(jobsDescription: Seq[JobDescription.TypeImpl]) = create(jobsDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

