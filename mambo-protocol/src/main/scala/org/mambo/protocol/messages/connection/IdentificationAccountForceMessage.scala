




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IdentificationAccountForceMessage extends IdentificationMessage {
  override val messageId = 6119

  protected trait Message extends IdentificationMessage.Message with Serializable {
    override val messageId = IdentificationAccountForceMessage.messageId

    val forcedAccountLogin: String

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeString(forcedAccountLogin)
    }

  }

  protected def create(autoconnect: Boolean, useCertificate: Boolean, useLoginToken: Boolean, version: VersionExtended.TypeImpl, lang: String, credentials: Seq[Byte], serverId: Short, forcedAccountLogin: String): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
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
    val forcedAccountLogin = buf.readString()

    create(autoconnect, useCertificate, useLoginToken, version, lang, credentials, serverId, forcedAccountLogin)
  }

}

object IdentificationAccountForceMessage extends IdentificationAccountForceMessage {
  case class MessageImpl(autoconnect: Boolean, useCertificate: Boolean, useLoginToken: Boolean, version: VersionExtended.TypeImpl, lang: String, credentials: Seq[Byte], serverId: Short, forcedAccountLogin: String) extends Message
  type Target = MessageImpl

  override def create(autoconnect: Boolean, useCertificate: Boolean, useLoginToken: Boolean, version: VersionExtended.TypeImpl, lang: String, credentials: Seq[Byte], serverId: Short, forcedAccountLogin: String) = MessageImpl(autoconnect, useCertificate, useLoginToken, version, lang, credentials, serverId, forcedAccountLogin)

  def apply(autoconnect: Boolean, useCertificate: Boolean, useLoginToken: Boolean, version: VersionExtended.TypeImpl, lang: String, credentials: Seq[Byte], serverId: Short, forcedAccountLogin: String) = create(autoconnect, useCertificate, useLoginToken, version, lang, credentials, serverId, forcedAccountLogin)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

