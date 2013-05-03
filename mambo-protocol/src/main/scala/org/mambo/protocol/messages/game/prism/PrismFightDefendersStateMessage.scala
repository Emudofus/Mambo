




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismFightDefendersStateMessage extends MessageDeserializer {
  val messageId = 5899

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismFightDefendersStateMessage.messageId

    val fightId: Double
    val mainFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]
    val reserveFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      buf.writeUShort(mainFighters.length)
      for (entry <- mainFighters) {
        entry.serialize(buf)
      }
      buf.writeUShort(reserveFighters.length)
      for (entry <- reserveFighters) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(fightId: Double, mainFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl], reserveFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val mainFighters = {
      val builder = collection.immutable.Seq.newBuilder[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterMinimalPlusLookAndGradeInformations.deserialize(buf)
      }
      builder.result()
    }
    val reserveFighters = {
      val builder = collection.immutable.Seq.newBuilder[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterMinimalPlusLookAndGradeInformations.deserialize(buf)
      }
      builder.result()
    }

    create(fightId, mainFighters, reserveFighters)
  }

}

object PrismFightDefendersStateMessage extends PrismFightDefendersStateMessage {
  case class MessageImpl(fightId: Double, mainFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl], reserveFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, mainFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl], reserveFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]) = MessageImpl(fightId, mainFighters, reserveFighters)

  def apply(fightId: Double, mainFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl], reserveFighters: Seq[CharacterMinimalPlusLookAndGradeInformations.TypeImpl]) = create(fightId, mainFighters, reserveFighters)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

