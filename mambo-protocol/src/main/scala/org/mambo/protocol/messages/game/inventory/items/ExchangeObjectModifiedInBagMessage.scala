




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeObjectModifiedInBagMessage extends ExchangeObjectMessage {
  override val messageId = 6008

  protected trait Message extends ExchangeObjectMessage.Message with Serializable {
    override val messageId = ExchangeObjectModifiedInBagMessage.messageId

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

object ExchangeObjectModifiedInBagMessage extends ExchangeObjectModifiedInBagMessage {
  case class MessageImpl(remote: Boolean, theObject: ObjectItem.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(remote: Boolean, theObject: ObjectItem.TypeImpl) = MessageImpl(remote, theObject)

  def apply(remote: Boolean, theObject: ObjectItem.TypeImpl) = create(remote, theObject)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

