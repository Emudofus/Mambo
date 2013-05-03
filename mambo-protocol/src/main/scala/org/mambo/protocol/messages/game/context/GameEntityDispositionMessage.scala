




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameEntityDispositionMessage extends MessageDeserializer {
  val messageId = 5693

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameEntityDispositionMessage.messageId

    val disposition: IdentifiedEntityDispositionInformations.TypeImpl

    def serialize(buf: Buffer) {
      disposition.serialize(buf)
    }

  }

  protected def create(disposition: IdentifiedEntityDispositionInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val disposition = IdentifiedEntityDispositionInformations.deserialize(buf)

    create(disposition)
  }

}

object GameEntityDispositionMessage extends GameEntityDispositionMessage {
  case class MessageImpl(disposition: IdentifiedEntityDispositionInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(disposition: IdentifiedEntityDispositionInformations.TypeImpl) = MessageImpl(disposition)

  def apply(disposition: IdentifiedEntityDispositionInformations.TypeImpl) = create(disposition)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

