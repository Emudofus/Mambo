




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectAveragePricesMessage extends MessageDeserializer {
  val messageId = 6335

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectAveragePricesMessage.messageId

    val ids: Seq[Short]
    val avgPrices: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(ids.length)
      for (entry <- ids) {
        buf.writeShort(entry)
      }
      buf.writeUShort(avgPrices.length)
      for (entry <- avgPrices) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(ids: Seq[Short], avgPrices: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val ids = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val avgPrices = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(ids, avgPrices)
  }

}

object ObjectAveragePricesMessage extends ObjectAveragePricesMessage {
  case class MessageImpl(ids: Seq[Short], avgPrices: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(ids: Seq[Short], avgPrices: Seq[Int]) = MessageImpl(ids, avgPrices)

  def apply(ids: Seq[Short], avgPrices: Seq[Int]) = create(ids, avgPrices)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

