




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectFoundWhileRecoltingMessage extends MessageDeserializer {
  val messageId = 6017

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectFoundWhileRecoltingMessage.messageId

    val genericId: Int
    val quantity: Int
    val ressourceGenericId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(genericId)
      buf.writeInt(quantity)
      buf.writeInt(ressourceGenericId)
    }

  }

  protected def create(genericId: Int, quantity: Int, ressourceGenericId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val genericId = buf.readInt()
    val quantity = buf.readInt()
    val ressourceGenericId = buf.readInt()

    create(genericId, quantity, ressourceGenericId)
  }

}

object ObjectFoundWhileRecoltingMessage extends ObjectFoundWhileRecoltingMessage {
  case class MessageImpl(genericId: Int, quantity: Int, ressourceGenericId: Int) extends Message
  type Target = MessageImpl

  override def create(genericId: Int, quantity: Int, ressourceGenericId: Int) = MessageImpl(genericId, quantity, ressourceGenericId)

  def apply(genericId: Int, quantity: Int, ressourceGenericId: Int) = create(genericId, quantity, ressourceGenericId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

