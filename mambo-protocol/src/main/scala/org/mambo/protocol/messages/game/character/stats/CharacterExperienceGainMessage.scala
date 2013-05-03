




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterExperienceGainMessage extends MessageDeserializer {
  val messageId = 6321

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterExperienceGainMessage.messageId

    val experienceCharacter: Double
    val experienceMount: Double
    val experienceGuild: Double
    val experienceIncarnation: Double

    def serialize(buf: Buffer) {
      buf.writeDouble(experienceCharacter)
      buf.writeDouble(experienceMount)
      buf.writeDouble(experienceGuild)
      buf.writeDouble(experienceIncarnation)
    }

  }

  protected def create(experienceCharacter: Double, experienceMount: Double, experienceGuild: Double, experienceIncarnation: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val experienceCharacter = buf.readDouble()
    val experienceMount = buf.readDouble()
    val experienceGuild = buf.readDouble()
    val experienceIncarnation = buf.readDouble()

    create(experienceCharacter, experienceMount, experienceGuild, experienceIncarnation)
  }

}

object CharacterExperienceGainMessage extends CharacterExperienceGainMessage {
  case class MessageImpl(experienceCharacter: Double, experienceMount: Double, experienceGuild: Double, experienceIncarnation: Double) extends Message
  type Target = MessageImpl

  override def create(experienceCharacter: Double, experienceMount: Double, experienceGuild: Double, experienceIncarnation: Double) = MessageImpl(experienceCharacter, experienceMount, experienceGuild, experienceIncarnation)

  def apply(experienceCharacter: Double, experienceMount: Double, experienceGuild: Double, experienceIncarnation: Double) = create(experienceCharacter, experienceMount, experienceGuild, experienceIncarnation)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

