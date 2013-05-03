




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StorageObjectsUpdateMessage extends MessageDeserializer {
  val messageId = 6036

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StorageObjectsUpdateMessage.messageId

    val objectList: Seq[ObjectItem.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(objectList.length)
      for (entry <- objectList) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(objectList: Seq[ObjectItem.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectList = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }

    create(objectList)
  }

}

object StorageObjectsUpdateMessage extends StorageObjectsUpdateMessage {
  case class MessageImpl(objectList: Seq[ObjectItem.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(objectList: Seq[ObjectItem.TypeImpl]) = MessageImpl(objectList)

  def apply(objectList: Seq[ObjectItem.TypeImpl]) = create(objectList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

