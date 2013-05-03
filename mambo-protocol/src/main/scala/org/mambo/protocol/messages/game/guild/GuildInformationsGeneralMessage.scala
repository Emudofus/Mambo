




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInformationsGeneralMessage extends MessageDeserializer {
  val messageId = 5557

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInformationsGeneralMessage.messageId

    val enabled: Boolean
    val abandonnedPaddock: Boolean
    val level: UByte
    val expLevelFloor: Double
    val experience: Double
    val expNextLevelFloor: Double
    val creationDate: Int

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, enabled)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, abandonnedPaddock)
      buf.writeUByte(flag1.toShort)
      buf.writeUByte(level)
      buf.writeDouble(expLevelFloor)
      buf.writeDouble(experience)
      buf.writeDouble(expNextLevelFloor)
      buf.writeInt(creationDate)
    }

  }

  protected def create(enabled: Boolean, abandonnedPaddock: Boolean, level: UByte, expLevelFloor: Double, experience: Double, expNextLevelFloor: Double, creationDate: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val enabled = BooleanByteWrapper.getFlag(flag1, 0)
    val abandonnedPaddock = BooleanByteWrapper.getFlag(flag1, 1)
    val level = buf.readUByte()
    val expLevelFloor = buf.readDouble()
    val experience = buf.readDouble()
    val expNextLevelFloor = buf.readDouble()
    val creationDate = buf.readInt()

    create(enabled, abandonnedPaddock, level, expLevelFloor, experience, expNextLevelFloor, creationDate)
  }

}

object GuildInformationsGeneralMessage extends GuildInformationsGeneralMessage {
  case class MessageImpl(enabled: Boolean, abandonnedPaddock: Boolean, level: UByte, expLevelFloor: Double, experience: Double, expNextLevelFloor: Double, creationDate: Int) extends Message
  type Target = MessageImpl

  override def create(enabled: Boolean, abandonnedPaddock: Boolean, level: UByte, expLevelFloor: Double, experience: Double, expNextLevelFloor: Double, creationDate: Int) = MessageImpl(enabled, abandonnedPaddock, level, expLevelFloor, experience, expNextLevelFloor, creationDate)

  def apply(enabled: Boolean, abandonnedPaddock: Boolean, level: UByte, expLevelFloor: Double, experience: Double, expNextLevelFloor: Double, creationDate: Int) = create(enabled, abandonnedPaddock, level, expLevelFloor, experience, expNextLevelFloor, creationDate)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

