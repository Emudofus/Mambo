




















// Generated on 05/03/2013 10:34:34
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameActionFightTackledMessage extends AbstractGameActionMessage {
  override val messageId = 1004

  protected trait Message extends AbstractGameActionMessage.Message with Serializable {
    override val messageId = GameActionFightTackledMessage.messageId

    val tacklersIds: Seq[Int]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(tacklersIds.length)
      for (entry <- tacklersIds) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(actionId: Short, sourceId: Int, tacklersIds: Seq[Int]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val actionId = buf.readShort()
    val sourceId = buf.readInt()
    val tacklersIds = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(actionId, sourceId, tacklersIds)
  }

}

object GameActionFightTackledMessage extends GameActionFightTackledMessage {
  case class MessageImpl(actionId: Short, sourceId: Int, tacklersIds: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(actionId: Short, sourceId: Int, tacklersIds: Seq[Int]) = MessageImpl(actionId, sourceId, tacklersIds)

  def apply(actionId: Short, sourceId: Int, tacklersIds: Seq[Int]) = create(actionId, sourceId, tacklersIds)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

