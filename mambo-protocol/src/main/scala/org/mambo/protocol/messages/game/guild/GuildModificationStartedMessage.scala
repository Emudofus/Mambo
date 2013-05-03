




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildModificationStartedMessage extends MessageDeserializer {
  val messageId = 6324

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildModificationStartedMessage.messageId

    val canChangeName: Boolean
    val canChangeEmblem: Boolean

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, canChangeName)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, canChangeEmblem)
      buf.writeUByte(flag1.toShort)
    }

  }

  protected def create(canChangeName: Boolean, canChangeEmblem: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val canChangeName = BooleanByteWrapper.getFlag(flag1, 0)
    val canChangeEmblem = BooleanByteWrapper.getFlag(flag1, 1)

    create(canChangeName, canChangeEmblem)
  }

}

object GuildModificationStartedMessage extends GuildModificationStartedMessage {
  case class MessageImpl(canChangeName: Boolean, canChangeEmblem: Boolean) extends Message
  type Target = MessageImpl

  override def create(canChangeName: Boolean, canChangeEmblem: Boolean) = MessageImpl(canChangeName, canChangeEmblem)

  def apply(canChangeName: Boolean, canChangeEmblem: Boolean) = create(canChangeName, canChangeEmblem)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

