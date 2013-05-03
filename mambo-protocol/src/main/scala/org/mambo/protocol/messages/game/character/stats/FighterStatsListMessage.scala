




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait FighterStatsListMessage extends MessageDeserializer {
  val messageId = 6322

  protected trait Message extends BaseMessage with Serializable {
    val messageId = FighterStatsListMessage.messageId

    val stats: CharacterCharacteristicsInformations.TypeImpl

    def serialize(buf: Buffer) {
      stats.serialize(buf)
    }

  }

  protected def create(stats: CharacterCharacteristicsInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val stats = CharacterCharacteristicsInformations.deserialize(buf)

    create(stats)
  }

}

object FighterStatsListMessage extends FighterStatsListMessage {
  case class MessageImpl(stats: CharacterCharacteristicsInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(stats: CharacterCharacteristicsInformations.TypeImpl) = MessageImpl(stats)

  def apply(stats: CharacterCharacteristicsInformations.TypeImpl) = create(stats)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

