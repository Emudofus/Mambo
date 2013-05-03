




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobLevelUpMessage extends MessageDeserializer {
  val messageId = 5656

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobLevelUpMessage.messageId

    val newLevel: Byte
    val jobsDescription: JobDescription.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeByte(newLevel)
      jobsDescription.serialize(buf)
    }

  }

  protected def create(newLevel: Byte, jobsDescription: JobDescription.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val newLevel = buf.readByte()
    val jobsDescription = JobDescription.deserialize(buf)

    create(newLevel, jobsDescription)
  }

}

object JobLevelUpMessage extends JobLevelUpMessage {
  case class MessageImpl(newLevel: Byte, jobsDescription: JobDescription.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(newLevel: Byte, jobsDescription: JobDescription.TypeImpl) = MessageImpl(newLevel, jobsDescription)

  def apply(newLevel: Byte, jobsDescription: JobDescription.TypeImpl) = create(newLevel, jobsDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

