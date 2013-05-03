




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobCrafterDirectorySettingsMessage extends MessageDeserializer {
  val messageId = 5652

  protected trait Message extends BaseMessage with Serializable {
    val messageId = JobCrafterDirectorySettingsMessage.messageId

    val craftersSettings: Seq[JobCrafterDirectorySettings.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(craftersSettings.length)
      for (entry <- craftersSettings) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(craftersSettings: Seq[JobCrafterDirectorySettings.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val craftersSettings = {
      val builder = collection.immutable.Seq.newBuilder[JobCrafterDirectorySettings.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += JobCrafterDirectorySettings.deserialize(buf)
      }
      builder.result()
    }

    create(craftersSettings)
  }

}

object JobCrafterDirectorySettingsMessage extends JobCrafterDirectorySettingsMessage {
  case class MessageImpl(craftersSettings: Seq[JobCrafterDirectorySettings.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(craftersSettings: Seq[JobCrafterDirectorySettings.TypeImpl]) = MessageImpl(craftersSettings)

  def apply(craftersSettings: Seq[JobCrafterDirectorySettings.TypeImpl]) = create(craftersSettings)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

