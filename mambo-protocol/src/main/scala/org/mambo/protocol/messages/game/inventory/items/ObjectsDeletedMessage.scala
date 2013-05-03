




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectsDeletedMessage extends MessageDeserializer {
  val messageId = 6034

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectsDeletedMessage.messageId

    val objectUID: Seq[Int]

    def serialize(buf: Buffer) {
      buf.writeUShort(objectUID.length)
      for (entry <- objectUID) {
        buf.writeInt(entry)
      }
    }

  }

  protected def create(objectUID: Seq[Int]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val objectUID = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }

    create(objectUID)
  }

}

object ObjectsDeletedMessage extends ObjectsDeletedMessage {
  case class MessageImpl(objectUID: Seq[Int]) extends Message
  type Target = MessageImpl

  override def create(objectUID: Seq[Int]) = MessageImpl(objectUID)

  def apply(objectUID: Seq[Int]) = create(objectUID)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

