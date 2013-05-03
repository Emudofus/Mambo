




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountRenameRequestMessage extends MessageDeserializer {
  val messageId = 5987

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountRenameRequestMessage.messageId

    val name: String
    val mountId: Double

    def serialize(buf: Buffer) {
      buf.writeString(name)
      buf.writeDouble(mountId)
    }

  }

  protected def create(name: String, mountId: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val name = buf.readString()
    val mountId = buf.readDouble()

    create(name, mountId)
  }

}

object MountRenameRequestMessage extends MountRenameRequestMessage {
  case class MessageImpl(name: String, mountId: Double) extends Message
  type Target = MessageImpl

  override def create(name: String, mountId: Double) = MessageImpl(name, mountId)

  def apply(name: String, mountId: Double) = create(name, mountId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

