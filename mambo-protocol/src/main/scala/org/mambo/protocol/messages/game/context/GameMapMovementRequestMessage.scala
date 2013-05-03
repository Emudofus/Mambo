




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameMapMovementRequestMessage extends MessageDeserializer {
  val messageId = 950

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameMapMovementRequestMessage.messageId

    val keyMovements: Seq[Short]
    val mapId: Int

    def serialize(buf: Buffer) {
      buf.writeUShort(keyMovements.length)
      for (entry <- keyMovements) {
        buf.writeShort(entry)
      }
      buf.writeInt(mapId)
    }

  }

  protected def create(keyMovements: Seq[Short], mapId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val keyMovements = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val mapId = buf.readInt()

    create(keyMovements, mapId)
  }

}

object GameMapMovementRequestMessage extends GameMapMovementRequestMessage {
  case class MessageImpl(keyMovements: Seq[Short], mapId: Int) extends Message
  type Target = MessageImpl

  override def create(keyMovements: Seq[Short], mapId: Int) = MessageImpl(keyMovements, mapId)

  def apply(keyMovements: Seq[Short], mapId: Int) = create(keyMovements, mapId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

