




















// Generated on 05/03/2013 10:35:00
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait StartupActionsListMessage extends MessageDeserializer {
  val messageId = 1301

  protected trait Message extends BaseMessage with Serializable {
    val messageId = StartupActionsListMessage.messageId

    val actions: Seq[StartupActionAddObject.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(actions.length)
      for (entry <- actions) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(actions: Seq[StartupActionAddObject.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val actions = {
      val builder = collection.immutable.Seq.newBuilder[StartupActionAddObject.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += StartupActionAddObject.deserialize(buf)
      }
      builder.result()
    }

    create(actions)
  }

}

object StartupActionsListMessage extends StartupActionsListMessage {
  case class MessageImpl(actions: Seq[StartupActionAddObject.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(actions: Seq[StartupActionAddObject.TypeImpl]) = MessageImpl(actions)

  def apply(actions: Seq[StartupActionAddObject.TypeImpl]) = create(actions)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

