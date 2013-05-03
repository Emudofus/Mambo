




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StorageObjectsRemoveMessage extends MessageDeserializer {
  val messageId = 6035

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StorageObjectsRemoveMessage.messageId

    val objectUIDList: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(objectUIDList.length)
      for (entry <- objectUIDList) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(objectUIDList: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectUIDList = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(objectUIDList)
  }

}

object StorageObjectsRemoveMessage extends StorageObjectsRemoveMessage {
  case class MessageImpl(objectUIDList: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(objectUIDList: Seq[Int]) = MessageImpl(objectUIDList)

  def apply(objectUIDList: Seq[Int]) = create(objectUIDList)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

