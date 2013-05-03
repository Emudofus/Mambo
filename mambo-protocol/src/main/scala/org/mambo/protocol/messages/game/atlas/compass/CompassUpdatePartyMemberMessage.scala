




















// Generated on 05/03/2013 10:34:35
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait CompassUpdatePartyMemberMessage extends CompassUpdateMessage {
  override val messageId = 5589

  protected trait Message extends CompassUpdateMessage.Message with Serializable {
    override val messageId = CompassUpdatePartyMemberMessage.messageId

    val memberId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(memberId)
    }

  }

  protected def create(theType: Byte, worldX: Short, worldY: Short, memberId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val theType = buf.readByte()
    val worldX = buf.readShort()
    val worldY = buf.readShort()
    val memberId = buf.readInt()

    create(theType, worldX, worldY, memberId)
  }

}

object CompassUpdatePartyMemberMessage extends CompassUpdatePartyMemberMessage {
  case class MessageImpl(theType: Byte, worldX: Short, worldY: Short, memberId: Int) extends Message
  type Target = MessageImpl

  override def create(theType: Byte, worldX: Short, worldY: Short, memberId: Int) = MessageImpl(theType, worldX, worldY, memberId)

  def apply(theType: Byte, worldX: Short, worldY: Short, memberId: Int) = create(theType, worldX, worldY, memberId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

