




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobExperienceMultiUpdateMessage extends MessageDeserializer {
  val messageId = 5809

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobExperienceMultiUpdateMessage.messageId

    val experiencesUpdate: Seq[JobExperience.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(experiencesUpdate.length)
      for (entry <- experiencesUpdate) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(experiencesUpdate: Seq[JobExperience.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val experiencesUpdate = {
      val builder = collection.immutable.Seq.newBuilder[JobExperience.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += JobExperience.deserialize(buf)
      }
      builder.result()
    }

    create(experiencesUpdate)
  }

}

object JobExperienceMultiUpdateMessage extends JobExperienceMultiUpdateMessage {
  case class MessageImpl(experiencesUpdate: Seq[JobExperience.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(experiencesUpdate: Seq[JobExperience.TypeImpl]) = MessageImpl(experiencesUpdate)

  def apply(experiencesUpdate: Seq[JobExperience.TypeImpl]) = create(experiencesUpdate)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

