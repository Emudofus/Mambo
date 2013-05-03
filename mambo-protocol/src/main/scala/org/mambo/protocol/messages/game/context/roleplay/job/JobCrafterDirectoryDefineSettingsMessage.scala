




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobCrafterDirectoryDefineSettingsMessage extends MessageDeserializer {
  val messageId = 5649

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobCrafterDirectoryDefineSettingsMessage.messageId

    val settings: JobCrafterDirectorySettings.TypeImpl

    def serialize(buf: Buffer) {
      settings.serialize(buf)
    }

  }

  protected def create(settings: JobCrafterDirectorySettings.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val settings = JobCrafterDirectorySettings.deserialize(buf)

    create(settings)
  }

}

object JobCrafterDirectoryDefineSettingsMessage extends JobCrafterDirectoryDefineSettingsMessage {
  case class MessageImpl(settings: JobCrafterDirectorySettings.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(settings: JobCrafterDirectorySettings.TypeImpl) = MessageImpl(settings)

  def apply(settings: JobCrafterDirectorySettings.TypeImpl) = create(settings)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

