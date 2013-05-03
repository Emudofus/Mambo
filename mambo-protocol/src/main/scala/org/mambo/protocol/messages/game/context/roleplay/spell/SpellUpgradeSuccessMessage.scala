




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SpellUpgradeSuccessMessage extends MessageDeserializer {
  val messageId = 1201

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SpellUpgradeSuccessMessage.messageId

    val spellId: Int
    val spellLevel: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(spellId)
      buf.writeByte(spellLevel)
    }

  }

  protected def create(spellId: Int, spellLevel: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellId = buf.readInt()
    val spellLevel = buf.readByte()

    create(spellId, spellLevel)
  }

}

object SpellUpgradeSuccessMessage extends SpellUpgradeSuccessMessage {
  case class MessageImpl(spellId: Int, spellLevel: Byte) extends Message
  type Target = MessageImpl

  override def create(spellId: Int, spellLevel: Byte) = MessageImpl(spellId, spellLevel)

  def apply(spellId: Int, spellLevel: Byte) = create(spellId, spellLevel)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

