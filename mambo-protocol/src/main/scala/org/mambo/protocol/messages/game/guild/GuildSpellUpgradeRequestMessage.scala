




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildSpellUpgradeRequestMessage extends MessageDeserializer {
  val messageId = 5699

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildSpellUpgradeRequestMessage.messageId

    val spellId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(spellId)
    }

  }

  protected def create(spellId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellId = buf.readInt()

    create(spellId)
  }

}

object GuildSpellUpgradeRequestMessage extends GuildSpellUpgradeRequestMessage {
  case class MessageImpl(spellId: Int) extends Message
  type Target = MessageImpl

  override def create(spellId: Int) = MessageImpl(spellId)

  def apply(spellId: Int) = create(spellId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

