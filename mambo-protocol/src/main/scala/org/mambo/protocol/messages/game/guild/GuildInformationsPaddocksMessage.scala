




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GuildInformationsPaddocksMessage extends MessageDeserializer {
  val messageId = 5959

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GuildInformationsPaddocksMessage.messageId

    val nbPaddockMax: Byte
    val paddocksInformations: Seq[PaddockContentInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeByte(nbPaddockMax)
      buf.writeUShort(paddocksInformations.length)
      for (entry <- paddocksInformations) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(nbPaddockMax: Byte, paddocksInformations: Seq[PaddockContentInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val nbPaddockMax = buf.readByte()
    val paddocksInformations = {
      val builder = collection.immutable.Seq.newBuilder[PaddockContentInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += PaddockContentInformations.deserialize(buf)
      }
      builder.result()
    }

    create(nbPaddockMax, paddocksInformations)
  }

}

object GuildInformationsPaddocksMessage extends GuildInformationsPaddocksMessage {
  case class MessageImpl(nbPaddockMax: Byte, paddocksInformations: Seq[PaddockContentInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(nbPaddockMax: Byte, paddocksInformations: Seq[PaddockContentInformations.TypeImpl]) = MessageImpl(nbPaddockMax, paddocksInformations)

  def apply(nbPaddockMax: Byte, paddocksInformations: Seq[PaddockContentInformations.TypeImpl]) = create(nbPaddockMax, paddocksInformations)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

