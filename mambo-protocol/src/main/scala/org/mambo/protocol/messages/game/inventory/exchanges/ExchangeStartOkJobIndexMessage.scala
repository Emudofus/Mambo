




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkJobIndexMessage extends MessageDeserializer {
  val messageId = 5819

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartOkJobIndexMessage.messageId

    val jobs: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(jobs.length)
      for (entry <- jobs) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(jobs: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val jobs = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(jobs)
  }

}

object ExchangeStartOkJobIndexMessage extends ExchangeStartOkJobIndexMessage {
  case class MessageImpl(jobs: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(jobs: Seq[Int]) = MessageImpl(jobs)

  def apply(jobs: Seq[Int]) = create(jobs)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

