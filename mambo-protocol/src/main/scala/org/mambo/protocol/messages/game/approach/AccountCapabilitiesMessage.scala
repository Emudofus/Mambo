




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AccountCapabilitiesMessage extends MessageDeserializer {
  val messageId = 6216

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AccountCapabilitiesMessage.messageId

    val accountId: Int
    val tutorialAvailable: Boolean
    val breedsVisible: Short
    val breedsAvailable: Short
    val status: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(accountId)
      buf.writeBoolean(tutorialAvailable)
      buf.writeShort(breedsVisible)
      buf.writeShort(breedsAvailable)
      buf.writeByte(status)
    }

  }

  protected def create(accountId: Int, tutorialAvailable: Boolean, breedsVisible: Short, breedsAvailable: Short, status: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val accountId = buf.readInt()
    val tutorialAvailable = buf.readBoolean()
    val breedsVisible = buf.readShort()
    val breedsAvailable = buf.readShort()
    val status = buf.readByte()

    create(accountId, tutorialAvailable, breedsVisible, breedsAvailable, status)
  }

}

object AccountCapabilitiesMessage extends AccountCapabilitiesMessage {
  case class MessageImpl(accountId: Int, tutorialAvailable: Boolean, breedsVisible: Short, breedsAvailable: Short, status: Byte) extends Message
  type Target = MessageImpl

  override def create(accountId: Int, tutorialAvailable: Boolean, breedsVisible: Short, breedsAvailable: Short, status: Byte) = MessageImpl(accountId, tutorialAvailable, breedsVisible, breedsAvailable, status)

  def apply(accountId: Int, tutorialAvailable: Boolean, breedsVisible: Short, breedsAvailable: Short, status: Byte) = create(accountId, tutorialAvailable, breedsVisible, breedsAvailable, status)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

