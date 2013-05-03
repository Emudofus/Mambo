




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StorageInventoryContentMessage extends InventoryContentMessage {
  override val messageId = 5646

  protected trait Message extends InventoryContentMessage.Message with Serializable {
    override val messageId = StorageInventoryContentMessage.messageId


    override def serialize(buf: Buffer) {
      super.serialize(buf)

    }

  }

  override def deserialize(buf: Buffer) = {
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

object StorageInventoryContentMessage extends StorageInventoryContentMessage {
  case class MessageImpl(objects: Seq[ObjectItem.TypeImpl], kamas: Int) extends Message
  type Target = MessageImpl

  override def create(objects: Seq[ObjectItem.TypeImpl], kamas: Int) = MessageImpl(objects, kamas)

  def apply(objects: Seq[ObjectItem.TypeImpl], kamas: Int) = create(objects, kamas)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

