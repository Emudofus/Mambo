




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SpellItemBoostMessage extends MessageDeserializer {
  val messageId = 6011

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SpellItemBoostMessage.messageId

    val statId: Int
    val spellId: Short
    val value: Short

    def serialize(buf: Buffer) {
      buf.writeInt(statId)
      buf.writeShort(spellId)
      buf.writeShort(value)
    }

  }

  protected def create(statId: Int, spellId: Short, value: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val statId = buf.readInt()
    val spellId = buf.readShort()
    val value = buf.readShort()

    create(statId, spellId, value)
  }

}

object SpellItemBoostMessage extends SpellItemBoostMessage {
  case class MessageImpl(statId: Int, spellId: Short, value: Short) extends Message
  type Target = MessageImpl

  override def create(statId: Int, spellId: Short, value: Short) = MessageImpl(statId, spellId, value)

  def apply(statId: Int, spellId: Short, value: Short) = create(statId, spellId, value)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

