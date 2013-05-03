




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeObjectRemovedFromBagMessage extends ExchangeObjectMessage {
  override val messageId = 6010

  protected trait Message extends ExchangeObjectMessage.Message with Serializable {
    override val messageId = ExchangeObjectRemovedFromBagMessage.messageId

    val objectUID: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(objectUID)
    }

  }

  protected def create(remote: Boolean, objectUID: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val remote = buf.readBoolean()
    val objectUID = buf.readInt()

    create(remote, objectUID)
  }

}

object ExchangeObjectRemovedFromBagMessage extends ExchangeObjectRemovedFromBagMessage {
  case class MessageImpl(remote: Boolean, objectUID: Int) extends Message
  type Target = MessageImpl

  override def create(remote: Boolean, objectUID: Int) = MessageImpl(remote, objectUID)

  def apply(remote: Boolean, objectUID: Int) = create(remote, objectUID)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

