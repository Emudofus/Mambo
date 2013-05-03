




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeMultiCraftCrafterCanUseHisRessourcesMessage extends MessageDeserializer {
  val messageId = 6020

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeMultiCraftCrafterCanUseHisRessourcesMessage.messageId

    val allowed: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(allowed)
    }

  }

  protected def create(allowed: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val allowed = buf.readBoolean()

    create(allowed)
  }

}

object ExchangeMultiCraftCrafterCanUseHisRessourcesMessage extends ExchangeMultiCraftCrafterCanUseHisRessourcesMessage {
  case class MessageImpl(allowed: Boolean) extends Message
  type Target = MessageImpl

  override def create(allowed: Boolean) = MessageImpl(allowed)

  def apply(allowed: Boolean) = create(allowed)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

