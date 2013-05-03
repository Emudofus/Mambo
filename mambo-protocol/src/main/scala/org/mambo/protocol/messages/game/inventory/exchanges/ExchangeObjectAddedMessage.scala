




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeObjectAddedMessage extends ExchangeObjectMessage {
  override val messageId = 5516

  protected trait Message extends ExchangeObjectMessage.Message with Serializable {
    override val messageId = ExchangeObjectAddedMessage.messageId

    val theObject: ObjectItem.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      theObject.serialize(buf)
    }

  }

  protected def create(remote: Boolean, theObject: ObjectItem.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val remote = buf.readBoolean()
    val theObject = ObjectItem.deserialize(buf)

    create(remote, theObject)
  }

}

object ExchangeObjectAddedMessage extends ExchangeObjectAddedMessage {
  case class MessageImpl(remote: Boolean, theObject: ObjectItem.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(remote: Boolean, theObject: ObjectItem.TypeImpl) = MessageImpl(remote, theObject)

  def apply(remote: Boolean, theObject: ObjectItem.TypeImpl) = create(remote, theObject)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

