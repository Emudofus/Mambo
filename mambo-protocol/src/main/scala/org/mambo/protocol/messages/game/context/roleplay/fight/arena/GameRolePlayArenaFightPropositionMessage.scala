




















// Generated on 05/03/2013 10:34:43
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameRolePlayArenaFightPropositionMessage extends MessageDeserializer {
  val messageId = 6276

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameRolePlayArenaFightPropositionMessage.messageId

    val fightId: Int
    val alliesId: Seq[Int]
    val duration: Short

    def serialize(buf: Buffer) {
      buf.writeInt(fightId)
      buf.writeUShort(alliesId.length)
      for (entry <- alliesId) {
        buf.writeInt(entry)
      }
      buf.writeShort(duration)
    }

  }

  protected def create(fightId: Int, alliesId: Seq[Int], duration: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fightId = buf.readInt()
    val alliesId = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val duration = buf.readShort()

    create(fightId, alliesId, duration)
  }

}

object GameRolePlayArenaFightPropositionMessage extends GameRolePlayArenaFightPropositionMessage {
  case class MessageImpl(fightId: Int, alliesId: Seq[Int], duration: Short) extends Message
  type Target = MessageImpl

  override def create(fightId: Int, alliesId: Seq[Int], duration: Short) = MessageImpl(fightId, alliesId, duration)

  def apply(fightId: Int, alliesId: Seq[Int], duration: Short) = create(fightId, alliesId, duration)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

