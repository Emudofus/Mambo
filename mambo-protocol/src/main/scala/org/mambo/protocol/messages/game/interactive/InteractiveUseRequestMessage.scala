




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InteractiveUseRequestMessage extends MessageDeserializer {
  val messageId = 5001

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InteractiveUseRequestMessage.messageId

    val elemId: Int
    val skillInstanceUid: Int

    def serialize(buf: Buffer) {
      buf.writeInt(elemId)
      buf.writeInt(skillInstanceUid)
    }

  }

  protected def create(elemId: Int, skillInstanceUid: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val elemId = buf.readInt()
    val skillInstanceUid = buf.readInt()

    create(elemId, skillInstanceUid)
  }

}

object InteractiveUseRequestMessage extends InteractiveUseRequestMessage {
  case class MessageImpl(elemId: Int, skillInstanceUid: Int) extends Message
  type Target = MessageImpl

  override def create(elemId: Int, skillInstanceUid: Int) = MessageImpl(elemId, skillInstanceUid)

  def apply(elemId: Int, skillInstanceUid: Int) = create(elemId, skillInstanceUid)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

