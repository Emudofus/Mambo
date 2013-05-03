




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CharacterCapabilitiesMessage extends MessageDeserializer {
  val messageId = 6339

  protected trait Message extends BaseMessage with Serializable {
    val messageId = CharacterCapabilitiesMessage.messageId

    val guildEmblemSymbolCategories: Int

    def serialize(buf: Buffer) {
      buf.writeInt(guildEmblemSymbolCategories)
    }

  }

  protected def create(guildEmblemSymbolCategories: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val guildEmblemSymbolCategories = buf.readInt()

    create(guildEmblemSymbolCategories)
  }

}

object CharacterCapabilitiesMessage extends CharacterCapabilitiesMessage {
  case class MessageImpl(guildEmblemSymbolCategories: Int) extends Message
  type Target = MessageImpl

  override def create(guildEmblemSymbolCategories: Int) = MessageImpl(guildEmblemSymbolCategories)

  def apply(guildEmblemSymbolCategories: Int) = create(guildEmblemSymbolCategories)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

