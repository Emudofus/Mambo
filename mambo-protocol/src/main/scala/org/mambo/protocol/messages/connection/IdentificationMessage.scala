




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IdentificationMessage extends MessageDeserializer {
  val messageId = 4

  protected trait Message extends BaseMessage with Serializable {
    val messageId = IdentificationMessage.messageId

    val autoconnect: Boolean
    val useCertificate: Boolean
    val useLoginToken: Boolean
    val version: VersionExtended.TypeImpl
    val lang: String
    val credentials: Seq[Byte]
    val serverId: Short

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, autoconnect)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, useCertificate)
      flag1 = BooleanByteWrapper.setFlag(flag1, 2, useLoginToken)
      buf.writeUByte(flag1.toShort)
      version.serialize(buf)
      buf.writeString(lang)
      buf.writeUShort(credentials.length)
      for (entry <- credentials) {
        buf.writeByte(entry)
      }
      buf.writeShort(serverId)
    }

  }

  protected def create(autoconnect: Boolean, useCertificate: Boolean, useLoginToken: Boolean, version: VersionExtended.TypeImpl, lang: String, credentials: Seq[Byte], serverId: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val autoconnect = BooleanByteWrapper.getFlag(flag1, 0)
    val useCertificate = BooleanByteWrapper.getFlag(flag1, 1)
    val useLoginToken = BooleanByteWrapper.getFlag(flag1, 2)
    val version = VersionExtended.deserialize(buf)
    val lang = buf.readString()
    val credentials = {
      val builder = collection.immutable.Seq.newBuilder[Byte]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readByte()
      }
      builder.result()
    }
    val serverId = buf.readShort()

    create(autoconnect, useCertificate, useLoginToken, version, lang, credentials, serverId)
  }

}

object IdentificationMessage extends IdentificationMessage {
  case class MessageImpl(autoconnect: Boolean, useCertificate: Boolean, useLoginToken: Boolean, version: VersionExtended.TypeImpl, lang: String, credentials: Seq[Byte], serverId: Short) extends Message
  type Target = MessageImpl

  override def create(autoconnect: Boolean, useCertificate: Boolean, useLoginToken: Boolean, version: VersionExtended.TypeImpl, lang: String, credentials: Seq[Byte], serverId: Short) = MessageImpl(autoconnect, useCertificate, useLoginToken, version, lang, credentials, serverId)

  def apply(autoconnect: Boolean, useCertificate: Boolean, useLoginToken: Boolean, version: VersionExtended.TypeImpl, lang: String, credentials: Seq[Byte], serverId: Short) = create(autoconnect, useCertificate, useLoginToken, version, lang, credentials, serverId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

