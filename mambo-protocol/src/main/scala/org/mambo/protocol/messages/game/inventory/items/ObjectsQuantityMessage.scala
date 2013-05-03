




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectsQuantityMessage extends MessageDeserializer {
  val messageId = 6206

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectsQuantityMessage.messageId

    val objectsUIDAndQty: Seq[ObjectItemQuantity.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(objectsUIDAndQty.length)
      for (entry <- objectsUIDAndQty) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(objectsUIDAndQty: Seq[ObjectItemQuantity.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectsUIDAndQty = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItemQuantity.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItemQuantity.deserialize(buf)
      }
      builder.result()
    }

    create(objectsUIDAndQty)
  }

}

object ObjectsQuantityMessage extends ObjectsQuantityMessage {
  case class MessageImpl(objectsUIDAndQty: Seq[ObjectItemQuantity.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(objectsUIDAndQty: Seq[ObjectItemQuantity.TypeImpl]) = MessageImpl(objectsUIDAndQty)

  def apply(objectsUIDAndQty: Seq[ObjectItemQuantity.TypeImpl]) = create(objectsUIDAndQty)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

