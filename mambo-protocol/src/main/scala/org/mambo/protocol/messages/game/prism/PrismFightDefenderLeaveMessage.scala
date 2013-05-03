




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismFightDefenderLeaveMessage extends MessageDeserializer {
  val messageId = 5892

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismFightDefenderLeaveMessage.messageId

    val fightId: Double
    val fighterToRemoveId: Int
    val successor: Int

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      buf.writeInt(fighterToRemoveId)
      buf.writeInt(successor)
    }

  }

  protected def create(fightId: Double, fighterToRemoveId: Int, successor: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val fighterToRemoveId = buf.readInt()
    val successor = buf.readInt()

    create(fightId, fighterToRemoveId, successor)
  }

}

object PrismFightDefenderLeaveMessage extends PrismFightDefenderLeaveMessage {
  case class MessageImpl(fightId: Double, fighterToRemoveId: Int, successor: Int) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, fighterToRemoveId: Int, successor: Int) = MessageImpl(fightId, fighterToRemoveId, successor)

  def apply(fightId: Double, fighterToRemoveId: Int, successor: Int) = create(fightId, fighterToRemoveId, successor)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

