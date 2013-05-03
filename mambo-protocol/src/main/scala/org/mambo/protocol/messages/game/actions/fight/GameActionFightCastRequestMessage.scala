




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightCastRequestMessage extends MessageDeserializer {
  val messageId = 1005

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameActionFightCastRequestMessage.messageId

    val spellId: Short
    val cellId: Short

    def serialize(buf: Buffer) {
      buf.writeShort(spellId)
      buf.writeShort(cellId)
    }

  }

  protected def create(spellId: Short, cellId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellId = buf.readShort()
    val cellId = buf.readShort()

    create(spellId, cellId)
  }

}

object GameActionFightCastRequestMessage extends GameActionFightCastRequestMessage {
  case class MessageImpl(spellId: Short, cellId: Short) extends Message
  type Target = MessageImpl

  override def create(spellId: Short, cellId: Short) = MessageImpl(spellId, cellId)

  def apply(spellId: Short, cellId: Short) = create(spellId, cellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

