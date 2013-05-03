




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeStartOkMountMessage extends ExchangeStartOkMountWithOutPaddockMessage {
  override val messageId = 5979

  protected trait Message extends ExchangeStartOkMountWithOutPaddockMessage.Message with Serializable {
    override val messageId = ExchangeStartOkMountMessage.messageId

    val paddockedMountsDescription: Seq[MountClientData.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(paddockedMountsDescription.length)
      for (entry <- paddockedMountsDescription) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(stabledMountsDescription: Seq[MountClientData.TypeImpl], paddockedMountsDescription: Seq[MountClientData.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val stabledMountsDescription = {
      val builder = collection.immutable.Seq.newBuilder[MountClientData.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MountClientData.deserialize(buf)
      }
      builder.result()
    }
    val paddockedMountsDescription = {
      val builder = collection.immutable.Seq.newBuilder[MountClientData.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MountClientData.deserialize(buf)
      }
      builder.result()
    }

    create(stabledMountsDescription, paddockedMountsDescription)
  }

}

object ExchangeStartOkMountMessage extends ExchangeStartOkMountMessage {
  case class MessageImpl(stabledMountsDescription: Seq[MountClientData.TypeImpl], paddockedMountsDescription: Seq[MountClientData.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(stabledMountsDescription: Seq[MountClientData.TypeImpl], paddockedMountsDescription: Seq[MountClientData.TypeImpl]) = MessageImpl(stabledMountsDescription, paddockedMountsDescription)

  def apply(stabledMountsDescription: Seq[MountClientData.TypeImpl], paddockedMountsDescription: Seq[MountClientData.TypeImpl]) = create(stabledMountsDescription, paddockedMountsDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

