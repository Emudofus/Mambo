




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkMountWithOutPaddockMessage extends MessageDeserializer {
  val messageId = 5991

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeStartOkMountWithOutPaddockMessage.messageId

    val stabledMountsDescription: Seq[MountClientData.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(stabledMountsDescription.length)
      for (entry <- stabledMountsDescription) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(stabledMountsDescription: Seq[MountClientData.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val stabledMountsDescription = {
      val builder = collection.immutable.Seq.newBuilder[MountClientData.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MountClientData.deserialize(buf)
      }
      builder.result()
    }

    create(stabledMountsDescription)
  }

}

object ExchangeStartOkMountWithOutPaddockMessage extends ExchangeStartOkMountWithOutPaddockMessage {
  case class MessageImpl(stabledMountsDescription: Seq[MountClientData.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(stabledMountsDescription: Seq[MountClientData.TypeImpl]) = MessageImpl(stabledMountsDescription)

  def apply(stabledMountsDescription: Seq[MountClientData.TypeImpl]) = create(stabledMountsDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

