




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GoldAddedMessage extends MessageDeserializer {
  val messageId = 6030

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GoldAddedMessage.messageId

    val gold: GoldItem.TypeImpl

    def serialize(buf: Buffer) {
      gold.serialize(buf)
    }

  }

  protected def create(gold: GoldItem.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val gold = GoldItem.deserialize(buf)

    create(gold)
  }

}

object GoldAddedMessage extends GoldAddedMessage {
  case class MessageImpl(gold: GoldItem.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(gold: GoldItem.TypeImpl) = MessageImpl(gold)

  def apply(gold: GoldItem.TypeImpl) = create(gold)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

