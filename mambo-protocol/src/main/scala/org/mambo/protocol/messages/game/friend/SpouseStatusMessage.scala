




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SpouseStatusMessage extends MessageDeserializer {
  val messageId = 6265

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SpouseStatusMessage.messageId

    val hasSpouse: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(hasSpouse)
    }

  }

  protected def create(hasSpouse: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val hasSpouse = buf.readBoolean()

    create(hasSpouse)
  }

}

object SpouseStatusMessage extends SpouseStatusMessage {
  case class MessageImpl(hasSpouse: Boolean) extends Message
  type Target = MessageImpl

  override def create(hasSpouse: Boolean) = MessageImpl(hasSpouse)

  def apply(hasSpouse: Boolean) = create(hasSpouse)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

