




















// Generated on 05/03/2013 10:34:49
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SpellForgetUIMessage extends MessageDeserializer {
  val messageId = 5565

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SpellForgetUIMessage.messageId

    val open: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(open)
    }

  }

  protected def create(open: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val open = buf.readBoolean()

    create(open)
  }

}

object SpellForgetUIMessage extends SpellForgetUIMessage {
  case class MessageImpl(open: Boolean) extends Message
  type Target = MessageImpl

  override def create(open: Boolean) = MessageImpl(open)

  def apply(open: Boolean) = create(open)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

