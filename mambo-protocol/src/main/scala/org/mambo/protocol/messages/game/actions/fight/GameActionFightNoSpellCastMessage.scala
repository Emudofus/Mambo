




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightNoSpellCastMessage extends MessageDeserializer {
  val messageId = 6132

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameActionFightNoSpellCastMessage.messageId

    val spellLevelId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(spellLevelId)
    }

  }

  protected def create(spellLevelId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellLevelId = buf.readInt()

    create(spellLevelId)
  }

}

object GameActionFightNoSpellCastMessage extends GameActionFightNoSpellCastMessage {
  case class MessageImpl(spellLevelId: Int) extends Message
  type Target = MessageImpl

  override def create(spellLevelId: Int) = MessageImpl(spellLevelId)

  def apply(spellLevelId: Int) = create(spellLevelId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

