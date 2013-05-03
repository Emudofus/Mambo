




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeMountStableBornAddMessage extends ExchangeMountStableAddMessage {
  override val messageId = 5966

  protected trait Message extends ExchangeMountStableAddMessage.Message with Serializable {
    override val messageId = ExchangeMountStableBornAddMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val mountDescription = MountClientData.deserialize(buf)

    create(mountDescription)
  }

}

object ExchangeMountStableBornAddMessage extends ExchangeMountStableBornAddMessage {
  case class MessageImpl(mountDescription: MountClientData.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(mountDescription: MountClientData.TypeImpl) = MessageImpl(mountDescription)

  def apply(mountDescription: MountClientData.TypeImpl) = create(mountDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

