




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterSelectedErrorMissingMapPackMessage extends CharacterSelectedErrorMessage {
  override val messageId = 6300

  protected trait Message extends CharacterSelectedErrorMessage.Message with Serializable {
    override val messageId = CharacterSelectedErrorMissingMapPackMessage.messageId

    val subAreaId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(subAreaId)
    }

  }

  protected def create(subAreaId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val subAreaId = buf.readInt()

    create(subAreaId)
  }

}

object CharacterSelectedErrorMissingMapPackMessage extends CharacterSelectedErrorMissingMapPackMessage {
  case class MessageImpl(subAreaId: Int) extends Message
  type Target = MessageImpl

  override def create(subAreaId: Int) = MessageImpl(subAreaId)

  def apply(subAreaId: Int) = create(subAreaId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

