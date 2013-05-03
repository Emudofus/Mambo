




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MapObstacleUpdateMessage extends MessageDeserializer {
  val messageId = 6051

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MapObstacleUpdateMessage.messageId

    val obstacles: Seq[MapObstacle.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(obstacles.length)
      for (entry <- obstacles) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(obstacles: Seq[MapObstacle.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val obstacles = {
      val builder = collection.immutable.Seq.newBuilder[MapObstacle.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MapObstacle.deserialize(buf)
      }
      builder.result()
    }

    create(obstacles)
  }

}

object MapObstacleUpdateMessage extends MapObstacleUpdateMessage {
  case class MessageImpl(obstacles: Seq[MapObstacle.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(obstacles: Seq[MapObstacle.TypeImpl]) = MessageImpl(obstacles)

  def apply(obstacles: Seq[MapObstacle.TypeImpl]) = create(obstacles)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

