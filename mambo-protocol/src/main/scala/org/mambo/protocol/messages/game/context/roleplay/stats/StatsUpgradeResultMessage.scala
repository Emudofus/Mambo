




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StatsUpgradeResultMessage extends MessageDeserializer {
  val messageId = 5609

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StatsUpgradeResultMessage.messageId

    val nbCharacBoost: Short

    def serialize(buf: Buffer) {
      buf.writeShort(nbCharacBoost)
    }

  }

  protected def create(nbCharacBoost: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val nbCharacBoost = buf.readShort()

    create(nbCharacBoost)
  }

}

object StatsUpgradeResultMessage extends StatsUpgradeResultMessage {
  case class MessageImpl(nbCharacBoost: Short) extends Message
  type Target = MessageImpl

  override def create(nbCharacBoost: Short) = MessageImpl(nbCharacBoost)

  def apply(nbCharacBoost: Short) = create(nbCharacBoost)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

