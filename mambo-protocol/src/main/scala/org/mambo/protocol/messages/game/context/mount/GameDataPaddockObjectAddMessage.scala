




















// Generated on 05/03/2013 10:34:41
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameDataPaddockObjectAddMessage extends MessageDeserializer {
  val messageId = 5990

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameDataPaddockObjectAddMessage.messageId

    val paddockItemDescription: PaddockItem.TypeImpl

    def serialize(buf: Buffer) {
      paddockItemDescription.serialize(buf)
    }

  }

  protected def create(paddockItemDescription: PaddockItem.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val paddockItemDescription = PaddockItem.deserialize(buf)

    create(paddockItemDescription)
  }

}

object GameDataPaddockObjectAddMessage extends GameDataPaddockObjectAddMessage {
  case class MessageImpl(paddockItemDescription: PaddockItem.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(paddockItemDescription: PaddockItem.TypeImpl) = MessageImpl(paddockItemDescription)

  def apply(paddockItemDescription: PaddockItem.TypeImpl) = create(paddockItemDescription)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

