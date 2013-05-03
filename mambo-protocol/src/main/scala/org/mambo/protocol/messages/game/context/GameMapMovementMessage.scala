




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameMapMovementMessage extends MessageDeserializer {
  val messageId = 951

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameMapMovementMessage.messageId

    val keyMovements: Seq[Short]
    val actorId: Int

    def serialize(buf: Buffer) {
      buf.writeUShort(keyMovements.length)
      for (entry <- keyMovements) {
        buf.writeShort(entry)
      }
      buf.writeInt(actorId)
    }

  }

  protected def create(keyMovements: Seq[Short], actorId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val keyMovements = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val actorId = buf.readInt()

    create(keyMovements, actorId)
  }

}

object GameMapMovementMessage extends GameMapMovementMessage {
  case class MessageImpl(keyMovements: Seq[Short], actorId: Int) extends Message
  type Target = MessageImpl

  override def create(keyMovements: Seq[Short], actorId: Int) = MessageImpl(keyMovements, actorId)

  def apply(keyMovements: Seq[Short], actorId: Int) = create(keyMovements, actorId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

