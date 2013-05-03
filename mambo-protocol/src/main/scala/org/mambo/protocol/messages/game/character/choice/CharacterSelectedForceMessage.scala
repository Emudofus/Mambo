




















// Generated on 05/03/2013 10:34:36
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterSelectedForceMessage extends MessageDeserializer {
  val messageId = 6068

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterSelectedForceMessage.messageId

    val id: Int

    def serialize(buf: Buffer) {
      buf.writeInt(id)
    }

  }

  protected def create(id: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readInt()

    create(id)
  }

}

object CharacterSelectedForceMessage extends CharacterSelectedForceMessage {
  case class MessageImpl(id: Int) extends Message
  type Target = MessageImpl

  override def create(id: Int) = MessageImpl(id)

  def apply(id: Int) = create(id)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

