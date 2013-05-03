




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlaySpellAnimMessage extends MessageDeserializer {
  val messageId = 6114

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlaySpellAnimMessage.messageId

    val casterId: Int
    val targetCellId: Short
    val spellId: Short
    val spellLevel: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(casterId)
      buf.writeShort(targetCellId)
      buf.writeShort(spellId)
      buf.writeByte(spellLevel)
    }

  }

  protected def create(casterId: Int, targetCellId: Short, spellId: Short, spellLevel: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val casterId = buf.readInt()
    val targetCellId = buf.readShort()
    val spellId = buf.readShort()
    val spellLevel = buf.readByte()

    create(casterId, targetCellId, spellId, spellLevel)
  }

}

object GameRolePlaySpellAnimMessage extends GameRolePlaySpellAnimMessage {
  case class MessageImpl(casterId: Int, targetCellId: Short, spellId: Short, spellLevel: Byte) extends Message
  type Target = MessageImpl

  override def create(casterId: Int, targetCellId: Short, spellId: Short, spellLevel: Byte) = MessageImpl(casterId, targetCellId, spellId, spellLevel)

  def apply(casterId: Int, targetCellId: Short, spellId: Short, spellLevel: Byte) = create(casterId, targetCellId, spellId, spellLevel)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

