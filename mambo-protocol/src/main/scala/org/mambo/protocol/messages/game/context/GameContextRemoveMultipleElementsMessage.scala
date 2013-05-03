




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameContextRemoveMultipleElementsMessage extends MessageDeserializer {
  val messageId = 252

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameContextRemoveMultipleElementsMessage.messageId

    val id: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(id.length)
      for (entry <- id) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(id: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(id)
  }

}

object GameContextRemoveMultipleElementsMessage extends GameContextRemoveMultipleElementsMessage {
  case class MessageImpl(id: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(id: Seq[Int]) = MessageImpl(id)

  def apply(id: Seq[Int]) = create(id)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

