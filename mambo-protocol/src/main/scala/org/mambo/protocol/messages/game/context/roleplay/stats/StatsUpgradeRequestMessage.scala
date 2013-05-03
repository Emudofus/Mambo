




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StatsUpgradeRequestMessage extends MessageDeserializer {
  val messageId = 5610

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StatsUpgradeRequestMessage.messageId

    val statId: Byte
    val boostPoint: Short

    def serialize(buf: Buffer) {
      buf.writeByte(statId)
      buf.writeShort(boostPoint)
    }

  }

  protected def create(statId: Byte, boostPoint: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val statId = buf.readByte()
    val boostPoint = buf.readShort()

    create(statId, boostPoint)
  }

}

object StatsUpgradeRequestMessage extends StatsUpgradeRequestMessage {
  case class MessageImpl(statId: Byte, boostPoint: Short) extends Message
  type Target = MessageImpl

  override def create(statId: Byte, boostPoint: Short) = MessageImpl(statId, boostPoint)

  def apply(statId: Byte, boostPoint: Short) = create(statId, boostPoint)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

