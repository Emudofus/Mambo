




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IdentificationFailedForBadVersionMessage extends IdentificationFailedMessage {
  override val messageId = 21

  protected trait Message extends IdentificationFailedMessage.Message with Serializable {
    override val messageId = IdentificationFailedForBadVersionMessage.messageId

    val requiredVersion: Version.TypeImpl

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      requiredVersion.serialize(buf)
    }

  }

  protected def create(reason: Byte, requiredVersion: Version.TypeImpl): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val reason = buf.readByte()
    val requiredVersion = Version.deserialize(buf)

    create(reason, requiredVersion)
  }

}

object IdentificationFailedForBadVersionMessage extends IdentificationFailedForBadVersionMessage {
  case class MessageImpl(reason: Byte, requiredVersion: Version.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(reason: Byte, requiredVersion: Version.TypeImpl) = MessageImpl(reason, requiredVersion)

  def apply(reason: Byte, requiredVersion: Version.TypeImpl) = create(reason, requiredVersion)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

