




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightCastOnTargetRequestMessage extends MessageDeserializer {
  val messageId = 6330

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameActionFightCastOnTargetRequestMessage.messageId

    val spellId: Short
    val targetId: Int

    def serialize(buf: Buffer) {
      buf.writeShort(spellId)
      buf.writeInt(targetId)
    }

  }

  protected def create(spellId: Short, targetId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellId = buf.readShort()
    val targetId = buf.readInt()

    create(spellId, targetId)
  }

}

object GameActionFightCastOnTargetRequestMessage extends GameActionFightCastOnTargetRequestMessage {
  case class MessageImpl(spellId: Short, targetId: Int) extends Message
  type Target = MessageImpl

  override def create(spellId: Short, targetId: Int) = MessageImpl(spellId, targetId)

  def apply(spellId: Short, targetId: Int) = create(spellId, targetId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

