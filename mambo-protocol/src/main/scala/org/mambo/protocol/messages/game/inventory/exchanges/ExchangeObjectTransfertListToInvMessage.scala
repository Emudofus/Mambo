




















// Generated on 05/03/2013 10:34:54
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeObjectTransfertListToInvMessage extends MessageDeserializer {
  val messageId = 6039

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeObjectTransfertListToInvMessage.messageId

    val ids: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(ids.length)
      for (entry <- ids) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(ids: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val ids = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(ids)
  }

}

object ExchangeObjectTransfertListToInvMessage extends ExchangeObjectTransfertListToInvMessage {
  case class MessageImpl(ids: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(ids: Seq[Int]) = MessageImpl(ids)

  def apply(ids: Seq[Int]) = create(ids)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

