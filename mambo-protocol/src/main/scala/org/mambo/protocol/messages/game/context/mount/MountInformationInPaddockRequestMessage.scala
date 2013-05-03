




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountInformationInPaddockRequestMessage extends MessageDeserializer {
  val messageId = 5975

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountInformationInPaddockRequestMessage.messageId

    val mapRideId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(mapRideId)
    }

  }

  protected def create(mapRideId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mapRideId = buf.readInt()

    create(mapRideId)
  }

}

object MountInformationInPaddockRequestMessage extends MountInformationInPaddockRequestMessage {
  case class MessageImpl(mapRideId: Int) extends Message
  type Target = MessageImpl

  override def create(mapRideId: Int) = MessageImpl(mapRideId)

  def apply(mapRideId: Int) = create(mapRideId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

