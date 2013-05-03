




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartInfoMessage extends MessageDeserializer {
  val messageId = 1508

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PartInfoMessage.messageId

    val part: ContentPart.TypeImpl
    val installationPercent: Float

    def serialize(buf: Buffer) {
      part.serialize(buf)
      buf.writeFloat(installationPercent)
    }

  }

  protected def create(part: ContentPart.TypeImpl, installationPercent: Float): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val part = ContentPart.deserialize(buf)
    val installationPercent = buf.readFloat()

    create(part, installationPercent)
  }

}

object PartInfoMessage extends PartInfoMessage {
  case class MessageImpl(part: ContentPart.TypeImpl, installationPercent: Float) extends Message
  type Target = MessageImpl

  override def create(part: ContentPart.TypeImpl, installationPercent: Float) = MessageImpl(part, installationPercent)

  def apply(part: ContentPart.TypeImpl, installationPercent: Float) = create(part, installationPercent)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

