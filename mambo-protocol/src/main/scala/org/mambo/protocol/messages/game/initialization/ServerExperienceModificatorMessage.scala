




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ServerExperienceModificatorMessage extends MessageDeserializer {
  val messageId = 6237

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ServerExperienceModificatorMessage.messageId

    val experiencePercent: Short

    def serialize(buf: Buffer) {
      buf.writeShort(experiencePercent)
    }

  }

  protected def create(experiencePercent: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val experiencePercent = buf.readShort()

    create(experiencePercent)
  }

}

object ServerExperienceModificatorMessage extends ServerExperienceModificatorMessage {
  case class MessageImpl(experiencePercent: Short) extends Message
  type Target = MessageImpl

  override def create(experiencePercent: Short) = MessageImpl(experiencePercent)

  def apply(experiencePercent: Short) = create(experiencePercent)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

