




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LifePointsRegenBeginMessage extends MessageDeserializer {
  val messageId = 5684

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LifePointsRegenBeginMessage.messageId

    val regenRate: UByte

    def serialize(buf: Buffer) {
      buf.writeUByte(regenRate)
    }

  }

  protected def create(regenRate: UByte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val regenRate = buf.readUByte()

    create(regenRate)
  }

}

object LifePointsRegenBeginMessage extends LifePointsRegenBeginMessage {
  case class MessageImpl(regenRate: UByte) extends Message
  type Target = MessageImpl

  override def create(regenRate: UByte) = MessageImpl(regenRate)

  def apply(regenRate: UByte) = create(regenRate)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

