




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SetCharacterRestrictionsMessage extends MessageDeserializer {
  val messageId = 170

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SetCharacterRestrictionsMessage.messageId

    val restrictions: ActorRestrictionsInformations.TypeImpl

    def serialize(buf: Buffer) {
      restrictions.serialize(buf)
    }

  }

  protected def create(restrictions: ActorRestrictionsInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val restrictions = ActorRestrictionsInformations.deserialize(buf)

    create(restrictions)
  }

}

object SetCharacterRestrictionsMessage extends SetCharacterRestrictionsMessage {
  case class MessageImpl(restrictions: ActorRestrictionsInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(restrictions: ActorRestrictionsInformations.TypeImpl) = MessageImpl(restrictions)

  def apply(restrictions: ActorRestrictionsInformations.TypeImpl) = create(restrictions)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

