




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismFightAttackerRemoveMessage extends MessageDeserializer {
  val messageId = 5897

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismFightAttackerRemoveMessage.messageId

    val fightId: Double
    val fighterToRemoveId: Int

    def serialize(buf: Buffer) {
      buf.writeDouble(fightId)
      buf.writeInt(fighterToRemoveId)
    }

  }

  protected def create(fightId: Double, fighterToRemoveId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readDouble()
    val fighterToRemoveId = buf.readInt()

    create(fightId, fighterToRemoveId)
  }

}

object PrismFightAttackerRemoveMessage extends PrismFightAttackerRemoveMessage {
  case class MessageImpl(fightId: Double, fighterToRemoveId: Int) extends Message
  type Target = MessageImpl

  override def create(fightId: Double, fighterToRemoveId: Int) = MessageImpl(fightId, fighterToRemoveId)

  def apply(fightId: Double, fighterToRemoveId: Int) = create(fightId, fighterToRemoveId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

