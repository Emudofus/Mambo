




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeMountPaddockAddMessage extends MessageDeserializer {
  val messageId = 6049

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeMountPaddockAddMessage.messageId

    val mountDescription: MountClientData.TypeImpl

    def serialize(buf: Buffer) {
      mountDescription.serialize(buf)
    }

  }

  protected def create(mountDescription: MountClientData.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mountDescription = MountClientData.deserialize(buf)

    create(mountDescription)
  }

}

object ExchangeMountPaddockAddMessage extends ExchangeMountPaddockAddMessage {
  case class MessageImpl(mountDescription: MountClientData.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(mountDescription: MountClientData.TypeImpl) = MessageImpl(mountDescription)

  def apply(mountDescription: MountClientData.TypeImpl) = create(mountDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

