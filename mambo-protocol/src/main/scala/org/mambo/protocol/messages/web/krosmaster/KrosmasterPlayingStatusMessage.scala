




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait KrosmasterPlayingStatusMessage extends MessageDeserializer {
  val messageId = 6347

  protected trait Message extends BaseMessage with Serializable {
    val messageId = KrosmasterPlayingStatusMessage.messageId

    val playing: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(playing)
    }

  }

  protected def create(playing: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playing = buf.readBoolean()

    create(playing)
  }

}

object KrosmasterPlayingStatusMessage extends KrosmasterPlayingStatusMessage {
  case class MessageImpl(playing: Boolean) extends Message
  type Target = MessageImpl

  override def create(playing: Boolean) = MessageImpl(playing)

  def apply(playing: Boolean) = create(playing)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

