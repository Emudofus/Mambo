




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MountFeedRequestMessage extends MessageDeserializer {
  val messageId = 6189

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MountFeedRequestMessage.messageId

    val mountUid: Double
    val mountLocation: Byte
    val mountFoodUid: Int
    val quantity: Int

    def serialize(buf: Buffer) {
      buf.writeDouble(mountUid)
      buf.writeByte(mountLocation)
      buf.writeInt(mountFoodUid)
      buf.writeInt(quantity)
    }

  }

  protected def create(mountUid: Double, mountLocation: Byte, mountFoodUid: Int, quantity: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mountUid = buf.readDouble()
    val mountLocation = buf.readByte()
    val mountFoodUid = buf.readInt()
    val quantity = buf.readInt()

    create(mountUid, mountLocation, mountFoodUid, quantity)
  }

}

object MountFeedRequestMessage extends MountFeedRequestMessage {
  case class MessageImpl(mountUid: Double, mountLocation: Byte, mountFoodUid: Int, quantity: Int) extends Message
  type Target = MessageImpl

  override def create(mountUid: Double, mountLocation: Byte, mountFoodUid: Int, quantity: Int) = MessageImpl(mountUid, mountLocation, mountFoodUid, quantity)

  def apply(mountUid: Double, mountLocation: Byte, mountFoodUid: Int, quantity: Int) = create(mountUid, mountLocation, mountFoodUid, quantity)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

