




















// Generated on 05/03/2013 10:34:56
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage extends MessageDeserializer {
  val messageId = 6021

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage.messageId

    val allow: Boolean

    def serialize(buf: Buffer) {
      buf.writeBoolean(allow)
    }

  }

  protected def create(allow: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val allow = buf.readBoolean()

    create(allow)
  }

}

object ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage extends ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage {
  case class MessageImpl(allow: Boolean) extends Message
  type Target = MessageImpl

  override def create(allow: Boolean) = MessageImpl(allow)

  def apply(allow: Boolean) = create(allow)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

