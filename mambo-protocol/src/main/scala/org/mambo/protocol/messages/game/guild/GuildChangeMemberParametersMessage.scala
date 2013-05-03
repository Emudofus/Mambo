




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildChangeMemberParametersMessage extends MessageDeserializer {
  val messageId = 5549

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildChangeMemberParametersMessage.messageId

    val memberId: Int
    val rank: Short
    val experienceGivenPercent: Byte
    val rights: UInt

    def serialize(buf: Buffer) {
      buf.writeInt(memberId)
      buf.writeShort(rank)
      buf.writeByte(experienceGivenPercent)
      buf.writeUInt(rights)
    }

  }

  protected def create(memberId: Int, rank: Short, experienceGivenPercent: Byte, rights: UInt): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val memberId = buf.readInt()
    val rank = buf.readShort()
    val experienceGivenPercent = buf.readByte()
    val rights = buf.readUInt()

    create(memberId, rank, experienceGivenPercent, rights)
  }

}

object GuildChangeMemberParametersMessage extends GuildChangeMemberParametersMessage {
  case class MessageImpl(memberId: Int, rank: Short, experienceGivenPercent: Byte, rights: UInt) extends Message
  type Target = MessageImpl

  override def create(memberId: Int, rank: Short, experienceGivenPercent: Byte, rights: UInt) = MessageImpl(memberId, rank, experienceGivenPercent, rights)

  def apply(memberId: Int, rank: Short, experienceGivenPercent: Byte, rights: UInt) = create(memberId, rank, experienceGivenPercent, rights)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

