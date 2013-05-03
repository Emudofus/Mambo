




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PackRestrictedSubAreaMessage extends MessageDeserializer {
  val messageId = 6186

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PackRestrictedSubAreaMessage.messageId

    val subAreaId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(subAreaId)
    }

  }

  protected def create(subAreaId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val subAreaId = buf.readInt()

    create(subAreaId)
  }

}

object PackRestrictedSubAreaMessage extends PackRestrictedSubAreaMessage {
  case class MessageImpl(subAreaId: Int) extends Message
  type Target = MessageImpl

  override def create(subAreaId: Int) = MessageImpl(subAreaId)

  def apply(subAreaId: Int) = create(subAreaId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

