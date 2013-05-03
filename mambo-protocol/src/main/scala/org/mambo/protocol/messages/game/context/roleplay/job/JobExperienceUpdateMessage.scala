




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobExperienceUpdateMessage extends MessageDeserializer {
  val messageId = 5654

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobExperienceUpdateMessage.messageId

    val experiencesUpdate: JobExperience.TypeImpl

    def serialize(buf: Buffer) {
      experiencesUpdate.serialize(buf)
    }

  }

  protected def create(experiencesUpdate: JobExperience.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val experiencesUpdate = JobExperience.deserialize(buf)

    create(experiencesUpdate)
  }

}

object JobExperienceUpdateMessage extends JobExperienceUpdateMessage {
  case class MessageImpl(experiencesUpdate: JobExperience.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(experiencesUpdate: JobExperience.TypeImpl) = MessageImpl(experiencesUpdate)

  def apply(experiencesUpdate: JobExperience.TypeImpl) = create(experiencesUpdate)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

