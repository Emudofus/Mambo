




















// Generated on 05/03/2013 10:34:44
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait HouseLockFromInsideRequestMessage extends LockableChangeCodeMessage {
  override val messageId = 5885

  protected trait Message extends LockableChangeCodeMessage.Message with Serializable {
    override val messageId = HouseLockFromInsideRequestMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
    val code = buf.readString()

    create(code)
  }

}

object HouseLockFromInsideRequestMessage extends HouseLockFromInsideRequestMessage {
  case class MessageImpl(code: String) extends Message
  type Target = MessageImpl

  override def create(code: String) = MessageImpl(code)

  def apply(code: String) = create(code)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

