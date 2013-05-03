




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightTurnListMessage extends MessageDeserializer {
  val messageId = 713

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightTurnListMessage.messageId

    val ids: Seq[Int]
    val deadsIds: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(ids.length)
      for (entry <- ids) {
        buf.writeInt(entry)
      }
      buf.writeUShort(deadsIds.length)
      for (entry <- deadsIds) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(ids: Seq[Int], deadsIds: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val ids = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val deadsIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(ids, deadsIds)
  }

}

object GameFightTurnListMessage extends GameFightTurnListMessage {
  case class MessageImpl(ids: Seq[Int], deadsIds: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(ids: Seq[Int], deadsIds: Seq[Int]) = MessageImpl(ids, deadsIds)

  def apply(ids: Seq[Int], deadsIds: Seq[Int]) = create(ids, deadsIds)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

