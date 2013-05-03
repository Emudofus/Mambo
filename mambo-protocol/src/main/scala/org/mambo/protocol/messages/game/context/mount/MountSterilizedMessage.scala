




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountSterilizedMessage extends MessageDeserializer {
  val messageId = 5977

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountSterilizedMessage.messageId

    val mountId: Double

    def serialize(buf: Buffer) {
      buf.writeDouble(mountId)
    }

  }

  protected def create(mountId: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mountId = buf.readDouble()

    create(mountId)
  }

}

object MountSterilizedMessage extends MountSterilizedMessage {
  case class MessageImpl(mountId: Double) extends Message
  type Target = MessageImpl

  override def create(mountId: Double) = MessageImpl(mountId)

  def apply(mountId: Double) = create(mountId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

