




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait BasicWhoIsMessage extends MessageDeserializer {
  val messageId = 180

  protected trait Message extends BaseMessage with Serializable {
    val messageId = BasicWhoIsMessage.messageId

    val self: Boolean
    val position: Byte
    val accountNickname: String
    val characterName: String
    val areaId: Short

    def serialize(buf: Buffer) {
      buf.writeBoolean(self)
      buf.writeByte(position)
      buf.writeString(accountNickname)
      buf.writeString(characterName)
      buf.writeShort(areaId)
    }

  }

  protected def create(self: Boolean, position: Byte, accountNickname: String, characterName: String, areaId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val self = buf.readBoolean()
    val position = buf.readByte()
    val accountNickname = buf.readString()
    val characterName = buf.readString()
    val areaId = buf.readShort()

    create(self, position, accountNickname, characterName, areaId)
  }

}

object BasicWhoIsMessage extends BasicWhoIsMessage {
  case class MessageImpl(self: Boolean, position: Byte, accountNickname: String, characterName: String, areaId: Short) extends Message
  type Target = MessageImpl

  override def create(self: Boolean, position: Byte, accountNickname: String, characterName: String, areaId: Short) = MessageImpl(self, position, accountNickname, characterName, areaId)

  def apply(self: Boolean, position: Byte, accountNickname: String, characterName: String, areaId: Short) = create(self, position, accountNickname, characterName, areaId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

