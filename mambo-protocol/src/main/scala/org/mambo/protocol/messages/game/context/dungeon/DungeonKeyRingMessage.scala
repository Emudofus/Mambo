




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DungeonKeyRingMessage extends MessageDeserializer {
  val messageId = 6299

  protected trait Message extends BaseMessage with Serializable {
    val messageId = DungeonKeyRingMessage.messageId

    val availables: Seq[Short]
    val unavailables: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(availables.length)
      for (entry <- availables) {
        buf.writeShort(entry)
      }
      buf.writeUShort(unavailables.length)
      for (entry <- unavailables) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(availables: Seq[Short], unavailables: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val availables = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val unavailables = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(availables, unavailables)
  }

}

object DungeonKeyRingMessage extends DungeonKeyRingMessage {
  case class MessageImpl(availables: Seq[Short], unavailables: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(availables: Seq[Short], unavailables: Seq[Short]) = MessageImpl(availables, unavailables)

  def apply(availables: Seq[Short], unavailables: Seq[Short]) = create(availables, unavailables)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

