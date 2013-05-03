




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountSetMessage extends MessageDeserializer {
  val messageId = 5968

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountSetMessage.messageId

    val mountData: MountClientData.TypeImpl

    def serialize(buf: Buffer) {
      mountData.serialize(buf)
    }

  }

  protected def create(mountData: MountClientData.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mountData = MountClientData.deserialize(buf)

    create(mountData)
  }

}

object MountSetMessage extends MountSetMessage {
  case class MessageImpl(mountData: MountClientData.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(mountData: MountClientData.TypeImpl) = MessageImpl(mountData)

  def apply(mountData: MountClientData.TypeImpl) = create(mountData)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

