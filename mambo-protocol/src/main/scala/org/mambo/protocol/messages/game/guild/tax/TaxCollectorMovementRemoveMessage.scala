




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TaxCollectorMovementRemoveMessage extends MessageDeserializer {
  val messageId = 5915

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TaxCollectorMovementRemoveMessage.messageId

    val collectorId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(collectorId)
    }

  }

  protected def create(collectorId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val collectorId = buf.readInt()

    create(collectorId)
  }

}

object TaxCollectorMovementRemoveMessage extends TaxCollectorMovementRemoveMessage {
  case class MessageImpl(collectorId: Int) extends Message
  type Target = MessageImpl

  override def create(collectorId: Int) = MessageImpl(collectorId)

  def apply(collectorId: Int) = create(collectorId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

