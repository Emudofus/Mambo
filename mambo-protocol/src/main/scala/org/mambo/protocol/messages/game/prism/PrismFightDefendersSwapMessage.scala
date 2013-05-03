




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismFightDefendersSwapMessage extends MessageDeserializer {
  val messageId = 5902

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismFightDefendersSwapMessage.messageId

    val fightId: Double
    val fighterId1: Int
    val fighterId2: Int

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      buf.writeInt(fighterId1)
      buf.writeInt(fighterId2)
    }

  }

  protected def create(fightId: Double, fighterId1: Int, fighterId2: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val fighterId1 = buf.readInt()
    val fighterId2 = buf.readInt()

    create(fightId, fighterId1, fighterId2)
  }

}

object PrismFightDefendersSwapMessage extends PrismFightDefendersSwapMessage {
  case class MessageImpl(fightId: Double, fighterId1: Int, fighterId2: Int) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, fighterId1: Int, fighterId2: Int) = MessageImpl(fightId, fighterId1, fighterId2)

  def apply(fightId: Double, fighterId1: Int, fighterId2: Int) = create(fightId, fighterId1, fighterId2)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

