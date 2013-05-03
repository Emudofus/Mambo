




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterSelectionWithRenameMessage extends CharacterSelectionMessage {
  override val messageId = 6121

  protected trait Message extends CharacterSelectionMessage.Message with Serializable {
    override val messageId = CharacterSelectionWithRenameMessage.messageId

    val name: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(name)
    }

  }

  protected def create(id: Int, name: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val name = buf.readString()

    create(id, name)
  }

}

object CharacterSelectionWithRenameMessage extends CharacterSelectionWithRenameMessage {
  case class MessageImpl(id: Int, name: String) extends Message
  type Target = MessageImpl

  override def create(id: Int, name: String) = MessageImpl(id, name)

  def apply(id: Int, name: String) = create(id, name)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

