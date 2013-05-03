




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountInformationRequestMessage extends MessageDeserializer {
  val messageId = 5972

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountInformationRequestMessage.messageId

    val id: Double
    val time: Double

    def serialize(buf: Buffer) {
      buf.writeDouble(id)
      buf.writeDouble(time)
    }

  }

  protected def create(id: Double, time: Double): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readDouble()
    val time = buf.readDouble()

    create(id, time)
  }

}

object MountInformationRequestMessage extends MountInformationRequestMessage {
  case class MessageImpl(id: Double, time: Double) extends Message
  type Target = MessageImpl

  override def create(id: Double, time: Double) = MessageImpl(id, time)

  def apply(id: Double, time: Double) = create(id, time)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

