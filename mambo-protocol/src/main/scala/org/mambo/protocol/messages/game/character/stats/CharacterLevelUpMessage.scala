




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterLevelUpMessage extends MessageDeserializer {
  val messageId = 5670

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterLevelUpMessage.messageId

    val newLevel: UByte

    def serialize(buf: Buffer) {
      buf.writeUByte(newLevel)
    }

  }

  protected def create(newLevel: UByte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val newLevel = buf.readUByte()

    create(newLevel)
  }

}

object CharacterLevelUpMessage extends CharacterLevelUpMessage {
  case class MessageImpl(newLevel: UByte) extends Message
  type Target = MessageImpl

  override def create(newLevel: UByte) = MessageImpl(newLevel)

  def apply(newLevel: UByte) = create(newLevel)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

