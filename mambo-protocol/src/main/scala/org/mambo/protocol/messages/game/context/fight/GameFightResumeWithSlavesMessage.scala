




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightResumeWithSlavesMessage extends GameFightResumeMessage {
  override val messageId = 6215

  protected trait Message extends GameFightResumeMessage.Message with Serializable {
    override val messageId = GameFightResumeWithSlavesMessage.messageId

    val slavesInfo: Seq[GameFightResumeSlaveInfo.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(slavesInfo.length)
      for (entry <- slavesInfo) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte, slavesInfo: Seq[GameFightResumeSlaveInfo.TypeImpl]): Target = throw new IllegalAccessException

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
    val slavesInfo = {
      val builder = collection.immutable.Seq.newBuilder[GameFightResumeSlaveInfo.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += GameFightResumeSlaveInfo.deserialize(buf)
      }
      builder.result()
    }

    create(effects, marks, gameTurn, spellCooldowns, summonCount, bombCount, slavesInfo)
  }

}

object GameFightResumeWithSlavesMessage extends GameFightResumeWithSlavesMessage {
  case class MessageImpl(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte, slavesInfo: Seq[GameFightResumeSlaveInfo.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte, slavesInfo: Seq[GameFightResumeSlaveInfo.TypeImpl]) = MessageImpl(effects, marks, gameTurn, spellCooldowns, summonCount, bombCount, slavesInfo)

  def apply(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte, slavesInfo: Seq[GameFightResumeSlaveInfo.TypeImpl]) = create(effects, marks, gameTurn, spellCooldowns, summonCount, bombCount, slavesInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

