




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait KamasUpdateMessage extends MessageDeserializer {
  val messageId = 5537

  protected trait Message extends BaseMessage with Serializable {
    val messageId = KamasUpdateMessage.messageId

    val kamasTotal: Int

    def serialize(buf: Buffer) {
      buf.writeInt(kamasTotal)
    }

  }

  protected def create(kamasTotal: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val kamasTotal = buf.readInt()

    create(kamasTotal)
  }

}

object KamasUpdateMessage extends KamasUpdateMessage {
  case class MessageImpl(kamasTotal: Int) extends Message
  type Target = MessageImpl

  override def create(kamasTotal: Int) = MessageImpl(kamasTotal)

  def apply(kamasTotal: Int) = create(kamasTotal)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

