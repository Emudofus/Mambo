




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightSpectateMessage extends MessageDeserializer {
  val messageId = 6069

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightSpectateMessage.messageId

    val effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl]
    val marks: Seq[GameActionMark.TypeImpl]
    val gameTurn: Short

    def serialize(buf: Buffer) {
      buf.writeUShort(effects.length)
      for (entry <- effects) {
        entry.serialize(buf)
      }
      buf.writeUShort(marks.length)
      for (entry <- marks) {
        entry.serialize(buf)
      }
      buf.writeShort(gameTurn)
    }

  }

  protected def create(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
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

    create(effects, marks, gameTurn)
  }

}

object GameFightSpectateMessage extends GameFightSpectateMessage {
  case class MessageImpl(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short) extends Message
  type Target = MessageImpl

  override def create(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short) = MessageImpl(effects, marks, gameTurn)

  def apply(effects: Seq[FightDispellableEffectExtendedInformations.TypeImpl], marks: Seq[GameActionMark.TypeImpl], gameTurn: Short) = create(effects, marks, gameTurn)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

