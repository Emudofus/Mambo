




















// Generated on 05/03/2013 10:34:37
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LifePointsRegenEndMessage extends UpdateLifePointsMessage {
  override val messageId = 5686

  protected trait Message extends UpdateLifePointsMessage.Message with Serializable {
    override val messageId = LifePointsRegenEndMessage.messageId

    val lifePointsGained: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(lifePointsGained)
    }

  }

  protected def create(lifePoints: Int, maxLifePoints: Int, lifePointsGained: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val lifePoints = buf.readInt()
    val maxLifePoints = buf.readInt()
    val lifePointsGained = buf.readInt()

    create(lifePoints, maxLifePoints, lifePointsGained)
  }

}

object LifePointsRegenEndMessage extends LifePointsRegenEndMessage {
  case class MessageImpl(lifePoints: Int, maxLifePoints: Int, lifePointsGained: Int) extends Message
  type Target = MessageImpl

  override def create(lifePoints: Int, maxLifePoints: Int, lifePointsGained: Int) = MessageImpl(lifePoints, maxLifePoints, lifePointsGained)

  def apply(lifePoints: Int, maxLifePoints: Int, lifePointsGained: Int) = create(lifePoints, maxLifePoints, lifePointsGained)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

