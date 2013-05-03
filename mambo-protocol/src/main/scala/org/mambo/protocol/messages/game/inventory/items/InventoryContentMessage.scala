




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait InventoryContentMessage extends MessageDeserializer {
  val messageId = 3016

  protected trait Message extends BaseMessage with Serializable {
    val messageId = InventoryContentMessage.messageId

    val objects: Seq[ObjectItem.TypeImpl]
    val kamas: Int

    def serialize(buf: Buffer) {
      buf.writeUShort(objects.length)
      for (entry <- objects) {
        entry.serialize(buf)
      }
      buf.writeInt(kamas)
    }

  }

  protected def create(objects: Seq[ObjectItem.TypeImpl], kamas: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objects = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }
    val kamas = buf.readInt()

    create(objects, kamas)
  }

}

object InventoryContentMessage extends InventoryContentMessage {
  case class MessageImpl(objects: Seq[ObjectItem.TypeImpl], kamas: Int) extends Message
  type Target = MessageImpl

  override def create(objects: Seq[ObjectItem.TypeImpl], kamas: Int) = MessageImpl(objects, kamas)

  def apply(objects: Seq[ObjectItem.TypeImpl], kamas: Int) = create(objects, kamas)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

