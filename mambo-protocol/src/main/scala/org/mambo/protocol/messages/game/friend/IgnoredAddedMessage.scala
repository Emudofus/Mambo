




















// Generated on 05/03/2013 10:34:50
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait IgnoredAddedMessage extends MessageDeserializer {
  val messageId = 5678

  protected trait Message extends BaseMessage with Serializable {
    val messageId = IgnoredAddedMessage.messageId

    val ignoreAdded: IgnoredInformations.TypeImpl
    val session: Boolean

    def serialize(buf: Buffer) {
      buf.writeUShort(ignoreAdded.typeId)
      ignoreAdded.serialize(buf)
      buf.writeBoolean(session)
    }

  }

  protected def create(ignoreAdded: IgnoredInformations.TypeImpl, session: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val ignoreAdded = types.get[IgnoredInformations.TypeImpl](buf.readShort());
    val session = buf.readBoolean()

    create(ignoreAdded, session)
  }

}

object IgnoredAddedMessage extends IgnoredAddedMessage {
  case class MessageImpl(ignoreAdded: IgnoredInformations.TypeImpl, session: Boolean) extends Message
  type Target = MessageImpl

  override def create(ignoreAdded: IgnoredInformations.TypeImpl, session: Boolean) = MessageImpl(ignoreAdded, session)

  def apply(ignoreAdded: IgnoredInformations.TypeImpl, session: Boolean) = create(ignoreAdded, session)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

