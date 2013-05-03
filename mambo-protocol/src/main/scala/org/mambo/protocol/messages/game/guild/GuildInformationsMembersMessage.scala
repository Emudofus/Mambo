




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInformationsMembersMessage extends MessageDeserializer {
  val messageId = 5558

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInformationsMembersMessage.messageId

    val members: Seq[GuildMember.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(members.length)
      for (entry <- members) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(members: Seq[GuildMember.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val members = {
      val builder = collection.immutable.Seq.newBuilder[GuildMember.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += GuildMember.deserialize(buf)
      }
      builder.result()
    }

    create(members)
  }

}

object GuildInformationsMembersMessage extends GuildInformationsMembersMessage {
  case class MessageImpl(members: Seq[GuildMember.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(members: Seq[GuildMember.TypeImpl]) = MessageImpl(members)

  def apply(members: Seq[GuildMember.TypeImpl]) = create(members)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

