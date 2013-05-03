




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ShowCellSpectatorMessage extends ShowCellMessage {
  override val messageId = 6158

  protected trait Message extends ShowCellMessage.Message with Serializable {
    override val messageId = ShowCellSpectatorMessage.messageId

    val playerName: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(playerName)
    }

  }

  protected def create(sourceId: Int, cellId: Short, playerName: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val sourceId = buf.readInt()
    val cellId = buf.readShort()
    val playerName = buf.readString()

    create(sourceId, cellId, playerName)
  }

}

object ShowCellSpectatorMessage extends ShowCellSpectatorMessage {
  case class MessageImpl(sourceId: Int, cellId: Short, playerName: String) extends Message
  type Target = MessageImpl

  override def create(sourceId: Int, cellId: Short, playerName: String) = MessageImpl(sourceId, cellId, playerName)

  def apply(sourceId: Int, cellId: Short, playerName: String) = create(sourceId, cellId, playerName)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

