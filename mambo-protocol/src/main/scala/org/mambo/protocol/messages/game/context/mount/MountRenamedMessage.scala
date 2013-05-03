




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountRenamedMessage extends MessageDeserializer {
  val messageId = 5983

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountRenamedMessage.messageId

    val mountId: Double
    val name: String

    def serialize(buf: Buffer) {
      buf.writeDouble(mountId)
      buf.writeString(name)
    }

  }

  protected def create(mountId: Double, name: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mountId = buf.readDouble()
    val name = buf.readString()

    create(mountId, name)
  }

}

object MountRenamedMessage extends MountRenamedMessage {
  case class MessageImpl(mountId: Double, name: String) extends Message
  type Target = MessageImpl

  override def create(mountId: Double, name: String) = MessageImpl(mountId, name)

  def apply(mountId: Double, name: String) = create(mountId, name)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

