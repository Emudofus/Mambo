




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LockableStateUpdateAbstractMessage extends MessageDeserializer {
  val messageId = 5671

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LockableStateUpdateAbstractMessage.messageId

    val locked: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(locked)
    }

  }

  protected def create(locked: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val locked = buf.readBoolean()

    create(locked)
  }

}

object LockableStateUpdateAbstractMessage extends LockableStateUpdateAbstractMessage {
  case class MessageImpl(locked: Boolean) extends Message
  type Target = MessageImpl

  override def create(locked: Boolean) = MessageImpl(locked)

  def apply(locked: Boolean) = create(locked)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

