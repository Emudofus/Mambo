




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterFirstSelectionMessage extends CharacterSelectionMessage {
  override val messageId = 6084

  protected trait Message extends CharacterSelectionMessage.Message with Serializable {
    override val messageId = CharacterFirstSelectionMessage.messageId

    val doTutorial: Boolean

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeBoolean(doTutorial)
    }

  }

  protected def create(id: Int, doTutorial: Boolean): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readInt()
    val doTutorial = buf.readBoolean()

    create(id, doTutorial)
  }

}

object CharacterFirstSelectionMessage extends CharacterFirstSelectionMessage {
  case class MessageImpl(id: Int, doTutorial: Boolean) extends Message
  type Target = MessageImpl

  override def create(id: Int, doTutorial: Boolean) = MessageImpl(id, doTutorial)

  def apply(id: Int, doTutorial: Boolean) = create(id, doTutorial)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

