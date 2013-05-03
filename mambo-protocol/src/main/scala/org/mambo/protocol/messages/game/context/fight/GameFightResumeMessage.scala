




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightResumeMessage extends GameFightSpectateMessage {
  override val messageId = 6067

  protected trait Message extends GameFightSpectateMessage.Message with Serializable {
    override val messageId = GameFightResumeMessage.messageId

    val spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl]
    val summonCount: Byte
    val bombCount: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(spellCooldowns.length)
      for (entry <- spellCooldowns) {
        entry.serialize(buf)
      }
      buf.writeByte(summonCount)
      buf.writeByte(bombCount)
    }

  }

  protected def create(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val effects = {
      val builder = collection.immutable.Seq.newBuilder[FightDispellableEffectExtendedInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += FightDispellableEffectExtendedInformations.deserialize(buf)
      }
      builder.result()
    }
    val marks = {
      val builder = collection.immutable.Seq.newBuilder[GameActionMark.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += GameActionMark.deserialize(buf)
      }
      builder.result()
    }
    val gameTurn = buf.readShort()
    val spellCooldowns = {
      val builder = collection.immutable.Seq.newBuilder[GameFightSpellCooldown.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += GameFightSpellCooldown.deserialize(buf)
      }
      builder.result()
    }
    val summonCount = buf.readByte()
    val bombCount = buf.readByte()

    create(effects, marks, gameTurn, spellCooldowns, summonCount, bombCount)
  }

}

object GameFightResumeMessage extends GameFightResumeMessage {
  case class MessageImpl(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte) extends Message
  type Target = MessageImpl

  override def create(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte) = MessageImpl(effects, marks, gameTurn, spellCooldowns, summonCount, bombCount)

  def apply(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte) = create(effects, marks, gameTurn, spellCooldowns, summonCount, bombCount)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

