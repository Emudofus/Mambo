




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ChallengeTargetsListMessage extends MessageDeserializer {
  val messageId = 5613

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ChallengeTargetsListMessage.messageId

    val targetIds: Seq[Int]
    val targetCells: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(targetIds.length)
      for (entry <- targetIds) {
        buf.writeInt(entry)
      }
      buf.writeUShort(targetCells.length)
      for (entry <- targetCells) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(targetIds: Seq[Int], targetCells: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val targetIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val targetCells = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(targetIds, targetCells)
  }

}

object ChallengeTargetsListMessage extends ChallengeTargetsListMessage {
  case class MessageImpl(targetIds: Seq[Int], targetCells: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(targetIds: Seq[Int], targetCells: Seq[Short]) = MessageImpl(targetIds, targetCells)

  def apply(targetIds: Seq[Int], targetCells: Seq[Short]) = create(targetIds, targetCells)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

