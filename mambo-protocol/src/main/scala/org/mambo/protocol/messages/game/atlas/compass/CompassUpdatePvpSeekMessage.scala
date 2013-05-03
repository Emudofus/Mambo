




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CompassUpdatePvpSeekMessage extends CompassUpdateMessage {
  override val messageId = 6013

  protected trait Message extends CompassUpdateMessage.Message with Serializable {
    override val messageId = CompassUpdatePvpSeekMessage.messageId

    val memberId: Int
    val memberName: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(memberId)
      buf.writeString(memberName)
    }

  }

  protected def create(theType: Byte, worldX: Short, worldY: Short, memberId: Int, memberName: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val theType = buf.readByte()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val memberId = buf.readInt()
    val memberName = buf.readString()

    create(theType, worldX, worldY, memberId, memberName)
  }

}

object CompassUpdatePvpSeekMessage extends CompassUpdatePvpSeekMessage {
  case class MessageImpl(theType: Byte, worldX: Short, worldY: Short, memberId: Int, memberName: String) extends Message
  type Target = MessageImpl

  override def create(theType: Byte, worldX: Short, worldY: Short, memberId: Int, memberName: String) = MessageImpl(theType, worldX, worldY, memberId, memberName)

  def apply(theType: Byte, worldX: Short, worldY: Short, memberId: Int, memberName: String) = create(theType, worldX, worldY, memberId, memberName)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

