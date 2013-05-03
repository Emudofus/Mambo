




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MapFightCountMessage extends MessageDeserializer {
  val messageId = 210

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MapFightCountMessage.messageId

    val fightCount: Short

    def serialize(buf: Buffer) {
      buf.writeShort(fightCount)
    }

  }

  protected def create(fightCount: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightCount = buf.readShort()

    create(fightCount)
  }

}

object MapFightCountMessage extends MapFightCountMessage {
  case class MessageImpl(fightCount: Short) extends Message
  type Target = MessageImpl

  override def create(fightCount: Short) = MessageImpl(fightCount)

  def apply(fightCount: Short) = create(fightCount)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

