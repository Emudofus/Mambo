




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StorageObjectUpdateMessage extends MessageDeserializer {
  val messageId = 5647

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StorageObjectUpdateMessage.messageId

    val theObject: ObjectItem.TypeImpl

    def serialize(buf: Buffer) {
      theObject.serialize(buf)
    }

  }

  protected def create(theObject: ObjectItem.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val theObject = ObjectItem.deserialize(buf)

    create(theObject)
  }

}

object StorageObjectUpdateMessage extends StorageObjectUpdateMessage {
  case class MessageImpl(theObject: ObjectItem.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(theObject: ObjectItem.TypeImpl) = MessageImpl(theObject)

  def apply(theObject: ObjectItem.TypeImpl) = create(theObject)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

