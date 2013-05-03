




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ObjectsAddedMessage extends MessageDeserializer {
  val messageId = 6033

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ObjectsAddedMessage.messageId

    val theObject: Seq[ObjectItem.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(theObject.length)
      for (entry <- theObject) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(theObject: Seq[ObjectItem.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theObject = {
      val builder = collection.immutable.Seq.newBuilder[ObjectItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectItem.deserialize(buf)
      }
      builder.result()
    }

    create(theObject)
  }

}

object ObjectsAddedMessage extends ObjectsAddedMessage {
  case class MessageImpl(theObject: Seq[ObjectItem.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(theObject: Seq[ObjectItem.TypeImpl]) = MessageImpl(theObject)

  def apply(theObject: Seq[ObjectItem.TypeImpl]) = create(theObject)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

