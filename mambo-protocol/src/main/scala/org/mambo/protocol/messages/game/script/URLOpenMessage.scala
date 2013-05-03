




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait URLOpenMessage extends MessageDeserializer {
  val messageId = 6266

  protected trait Message extends BaseMessage with Serializable {
    val messageId = URLOpenMessage.messageId

    val urlId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(urlId)
    }

  }

  protected def create(urlId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val urlId = buf.readInt()

    create(urlId)
  }

}

object URLOpenMessage extends URLOpenMessage {
  case class MessageImpl(urlId: Int) extends Message
  type Target = MessageImpl

  override def create(urlId: Int) = MessageImpl(urlId)

  def apply(urlId: Int) = create(urlId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

