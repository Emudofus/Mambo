




















// Generated on 05/03/2013 10:34:51
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayTaxCollectorFightRequestMessage extends MessageDeserializer {
  val messageId = 5954

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayTaxCollectorFightRequestMessage.messageId

    val taxCollectorId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(taxCollectorId)
    }

  }

  protected def create(taxCollectorId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val taxCollectorId = buf.readInt()

    create(taxCollectorId)
  }

}

object GameRolePlayTaxCollectorFightRequestMessage extends GameRolePlayTaxCollectorFightRequestMessage {
  case class MessageImpl(taxCollectorId: Int) extends Message
  type Target = MessageImpl

  override def create(taxCollectorId: Int) = MessageImpl(taxCollectorId)

  def apply(taxCollectorId: Int) = create(taxCollectorId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

