




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SpellListMessage extends MessageDeserializer {
  val messageId = 1200

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SpellListMessage.messageId

    val spellPrevisualization: Boolean
    val spells: Seq[SpellItem.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeBoolean(spellPrevisualization)
      buf.writeUShort(spells.length)
      for (entry <- spells) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(spellPrevisualization: Boolean, spells: Seq[SpellItem.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val spellPrevisualization = buf.readBoolean()
    val spells = {
      val builder = collection.immutable.Seq.newBuilder[SpellItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += SpellItem.deserialize(buf)
      }
      builder.result()
    }

    create(spellPrevisualization, spells)
  }

}

object SpellListMessage extends SpellListMessage {
  case class MessageImpl(spellPrevisualization: Boolean, spells: Seq[SpellItem.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(spellPrevisualization: Boolean, spells: Seq[SpellItem.TypeImpl]) = MessageImpl(spellPrevisualization, spells)

  def apply(spellPrevisualization: Boolean, spells: Seq[SpellItem.TypeImpl]) = create(spellPrevisualization, spells)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

