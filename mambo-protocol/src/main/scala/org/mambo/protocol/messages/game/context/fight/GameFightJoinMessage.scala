




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightJoinMessage extends MessageDeserializer {
  val messageId = 702

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightJoinMessage.messageId

    val canBeCancelled: Boolean
    val canSayReady: Boolean
    val isSpectator: Boolean
    val isFightStarted: Boolean
    val timeMaxBeforeFightStart: Int
    val fightType: Byte

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, canBeCancelled)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, canSayReady)
      flag1 = BooleanByteWrapper.setFlag(flag1, 2, isSpectator)
      flag1 = BooleanByteWrapper.setFlag(flag1, 3, isFightStarted)
      buf.writeUByte(flag1.toShort)
      buf.writeInt(timeMaxBeforeFightStart)
      buf.writeByte(fightType)
    }

  }

  protected def create(canBeCancelled: Boolean, canSayReady: Boolean, isSpectator: Boolean, isFightStarted: Boolean, timeMaxBeforeFightStart: Int, fightType: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val canBeCancelled = BooleanByteWrapper.getFlag(flag1, 0)
    val canSayReady = BooleanByteWrapper.getFlag(flag1, 1)
    val isSpectator = BooleanByteWrapper.getFlag(flag1, 2)
    val isFightStarted = BooleanByteWrapper.getFlag(flag1, 3)
    val timeMaxBeforeFightStart = buf.readInt()
    val fightType = buf.readByte()

    create(canBeCancelled, canSayReady, isSpectator, isFightStarted, timeMaxBeforeFightStart, fightType)
  }

}

object GameFightJoinMessage extends GameFightJoinMessage {
  case class MessageImpl(canBeCancelled: Boolean, canSayReady: Boolean, isSpectator: Boolean, isFightStarted: Boolean, timeMaxBeforeFightStart: Int, fightType: Byte) extends Message
  type Target = MessageImpl

  override def create(canBeCancelled: Boolean, canSayReady: Boolean, isSpectator: Boolean, isFightStarted: Boolean, timeMaxBeforeFightStart: Int, fightType: Byte) = MessageImpl(canBeCancelled, canSayReady, isSpectator, isFightStarted, timeMaxBeforeFightStart, fightType)

  def apply(canBeCancelled: Boolean, canSayReady: Boolean, isSpectator: Boolean, isFightStarted: Boolean, timeMaxBeforeFightStart: Int, fightType: Byte) = create(canBeCancelled, canSayReady, isSpectator, isFightStarted, timeMaxBeforeFightStart, fightType)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

