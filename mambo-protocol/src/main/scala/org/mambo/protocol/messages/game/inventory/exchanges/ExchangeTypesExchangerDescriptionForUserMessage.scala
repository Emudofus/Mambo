




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeTypesExchangerDescriptionForUserMessage extends MessageDeserializer {
  val messageId = 5765

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeTypesExchangerDescriptionForUserMessage.messageId

    val typeDescription: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(typeDescription.length)
      for (entry <- typeDescription) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(typeDescription: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val typeDescription = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(typeDescription)
  }

}

object ExchangeTypesExchangerDescriptionForUserMessage extends ExchangeTypesExchangerDescriptionForUserMessage {
  case class MessageImpl(typeDescription: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(typeDescription: Seq[Int]) = MessageImpl(typeDescription)

  def apply(typeDescription: Seq[Int]) = create(typeDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

