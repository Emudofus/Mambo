




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseGuildShareRequestMessage extends MessageDeserializer {
  val messageId = 5704

  protected trait Message extends BaseMessage with Serializable {
    val messageId = HouseGuildShareRequestMessage.messageId

    val enable: Boolean
    val rights: UInt

    def serialize(buf: Buffer) {
      buf.writeBoolean(enable)
      buf.writeUInt(rights)
    }

  }

  protected def create(enable: Boolean, rights: UInt): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val enable = buf.readBoolean()
    val rights = buf.readUInt()

    create(enable, rights)
  }

}

object HouseGuildShareRequestMessage extends HouseGuildShareRequestMessage {
  case class MessageImpl(enable: Boolean, rights: UInt) extends Message
  type Target = MessageImpl

  override def create(enable: Boolean, rights: UInt) = MessageImpl(enable, rights)

  def apply(enable: Boolean, rights: UInt) = create(enable, rights)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

