




















// Generated on 05/03/2013 10:34:59
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PrismInfoValidMessage extends MessageDeserializer {
  val messageId = 5858

  protected trait Message extends BaseMessage with Serializable {
    val messageId = PrismInfoValidMessage.messageId

    val waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl

    def serialize(buf: Buffer) {
      waitingForHelpInfo.serialize(buf)
    }

  }

  protected def create(waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val waitingForHelpInfo = ProtectedEntityWaitingForHelpInfo.deserialize(buf)

    create(waitingForHelpInfo)
  }

}

object PrismInfoValidMessage extends PrismInfoValidMessage {
  case class MessageImpl(waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl) = MessageImpl(waitingForHelpInfo)

  def apply(waitingForHelpInfo: ProtectedEntityWaitingForHelpInfo.TypeImpl) = create(waitingForHelpInfo)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

