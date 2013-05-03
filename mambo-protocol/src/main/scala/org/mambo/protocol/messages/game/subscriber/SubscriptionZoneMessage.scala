




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SubscriptionZoneMessage extends MessageDeserializer {
  val messageId = 5573

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SubscriptionZoneMessage.messageId

    val active: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(active)
    }

  }

  protected def create(active: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val active = buf.readBoolean()

    create(active)
  }

}

object SubscriptionZoneMessage extends SubscriptionZoneMessage {
  case class MessageImpl(active: Boolean) extends Message
  type Target = MessageImpl

  override def create(active: Boolean) = MessageImpl(active)

  def apply(active: Boolean) = create(active)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

