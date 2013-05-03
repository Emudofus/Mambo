




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ValidateSpellForgetMessage extends MessageDeserializer {
  val messageId = 1700

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ValidateSpellForgetMessage.messageId

    val spellId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(spellId)
    }

  }

  protected def create(spellId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellId = buf.readShort()

    create(spellId)
  }

}

object ValidateSpellForgetMessage extends ValidateSpellForgetMessage {
  case class MessageImpl(spellId: Short) extends Message
  type Target = MessageImpl

  override def create(spellId: Short) = MessageImpl(spellId)

  def apply(spellId: Short) = create(spellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

