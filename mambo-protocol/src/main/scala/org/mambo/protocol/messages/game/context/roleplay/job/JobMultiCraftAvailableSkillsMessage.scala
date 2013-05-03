




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait JobMultiCraftAvailableSkillsMessage extends JobAllowMultiCraftRequestMessage {
  override val messageId = 5747

  protected trait Message extends JobAllowMultiCraftRequestMessage.Message with Serializable {
    override val messageId = JobMultiCraftAvailableSkillsMessage.messageId

    val playerId: Int
    val skills: Seq[Short]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(playerId)
      buf.writeUShort(skills.length)
      for (entry <- skills) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(enabled: Boolean, playerId: Int, skills: Seq[Short]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val enabled = buf.readBoolean()
    val playerId = buf.readInt()
    val skills = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(enabled, playerId, skills)
  }

}

object JobMultiCraftAvailableSkillsMessage extends JobMultiCraftAvailableSkillsMessage {
  case class MessageImpl(enabled: Boolean, playerId: Int, skills: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(enabled: Boolean, playerId: Int, skills: Seq[Short]) = MessageImpl(enabled, playerId, skills)

  def apply(enabled: Boolean, playerId: Int, skills: Seq[Short]) = create(enabled, playerId, skills)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

