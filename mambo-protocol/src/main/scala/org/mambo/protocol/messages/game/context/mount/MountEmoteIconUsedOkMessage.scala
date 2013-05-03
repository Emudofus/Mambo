




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountEmoteIconUsedOkMessage extends MessageDeserializer {
  val messageId = 5978

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountEmoteIconUsedOkMessage.messageId

    val mountId: Int
    val reactionType: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(mountId)
      buf.writeByte(reactionType)
    }

  }

  protected def create(mountId: Int, reactionType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mountId = buf.readInt()
    val reactionType = buf.readByte()

    create(mountId, reactionType)
  }

}

object MountEmoteIconUsedOkMessage extends MountEmoteIconUsedOkMessage {
  case class MessageImpl(mountId: Int, reactionType: Byte) extends Message
  type Target = MessageImpl

  override def create(mountId: Int, reactionType: Byte) = MessageImpl(mountId, reactionType)

  def apply(mountId: Int, reactionType: Byte) = create(mountId, reactionType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

