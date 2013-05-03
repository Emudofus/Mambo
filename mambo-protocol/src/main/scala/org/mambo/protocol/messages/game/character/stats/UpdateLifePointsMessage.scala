




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait UpdateLifePointsMessage extends MessageDeserializer {
  val messageId = 5658

  protected trait Message extends BaseMessage with Serializable {
    val messageId = UpdateLifePointsMessage.messageId

    val lifePoints: Int
    val maxLifePoints: Int

    def serialize(buf: Buffer) {
      buf.writeInt(lifePoints)
      buf.writeInt(maxLifePoints)
    }

  }

  protected def create(lifePoints: Int, maxLifePoints: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val lifePoints = buf.readInt()
    val maxLifePoints = buf.readInt()

    create(lifePoints, maxLifePoints)
  }

}

object UpdateLifePointsMessage extends UpdateLifePointsMessage {
  case class MessageImpl(lifePoints: Int, maxLifePoints: Int) extends Message
  type Target = MessageImpl

  override def create(lifePoints: Int, maxLifePoints: Int) = MessageImpl(lifePoints, maxLifePoints)

  def apply(lifePoints: Int, maxLifePoints: Int) = create(lifePoints, maxLifePoints)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

