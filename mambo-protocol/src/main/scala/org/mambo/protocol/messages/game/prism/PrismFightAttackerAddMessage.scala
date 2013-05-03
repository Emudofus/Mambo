




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismFightAttackerAddMessage extends MessageDeserializer {
  val messageId = 5893

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismFightAttackerAddMessage.messageId

    val fightId: Double
    val charactersDescription: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      buf.writeUShort(charactersDescription.length)
      for (entry <- charactersDescription) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(fightId: Double, charactersDescription: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val charactersDescription = {
      val builder = collection.immutable.Seq.newBuilder[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterMinimalPlusLookAndGradeInformations.deserialize(buf)
      }
      builder.result()
    }

    create(fightId, charactersDescription)
  }

}

object PrismFightAttackerAddMessage extends PrismFightAttackerAddMessage {
  case class MessageImpl(fightId: Double, charactersDescription: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, charactersDescription: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]) = MessageImpl(fightId, charactersDescription)

  def apply(fightId: Double, charactersDescription: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]) = create(fightId, charactersDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

