




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterLevelUpInformationMessage extends CharacterLevelUpMessage {
  override val messageId = 6076

  protected trait Message extends CharacterLevelUpMessage.Message with Serializable {
    override val messageId = CharacterLevelUpInformationMessage.messageId

    val name: String
    val id: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(name)
      buf.writeInt(id)
    }

  }

  protected def create(newLevel: UByte, name: String, id: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val newLevel = buf.readUByte()
    val name = buf.readString()
    val id = buf.readInt()

    create(newLevel, name, id)
  }

}

object CharacterLevelUpInformationMessage extends CharacterLevelUpInformationMessage {
  case class MessageImpl(newLevel: UByte, name: String, id: Int) extends Message
  type Target = MessageImpl

  override def create(newLevel: UByte, name: String, id: Int) = MessageImpl(newLevel, name, id)

  def apply(newLevel: UByte, name: String, id: Int) = create(newLevel, name, id)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

