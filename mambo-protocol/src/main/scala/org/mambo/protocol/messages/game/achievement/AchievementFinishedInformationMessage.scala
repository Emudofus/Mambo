




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AchievementFinishedInformationMessage extends AchievementFinishedMessage {
  override val messageId = 6381

  protected trait Message extends AchievementFinishedMessage.Message with Serializable {
    override val messageId = AchievementFinishedInformationMessage.messageId

    val name: String
    val playerId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(name)
      buf.writeInt(playerId)
    }

  }

  protected def create(id: Short, finishedlevel: Short, name: String, playerId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val id = buf.readShort()
    val finishedlevel = buf.readShort()
    val name = buf.readString()
    val playerId = buf.readInt()

    create(id, finishedlevel, name, playerId)
  }

}

object AchievementFinishedInformationMessage extends AchievementFinishedInformationMessage {
  case class MessageImpl(id: Short, finishedlevel: Short, name: String, playerId: Int) extends Message
  type Target = MessageImpl

  override def create(id: Short, finishedlevel: Short, name: String, playerId: Int) = MessageImpl(id, finishedlevel, name, playerId)

  def apply(id: Short, finishedlevel: Short, name: String, playerId: Int) = create(id, finishedlevel, name, playerId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

