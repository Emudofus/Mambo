




















// Generated on 05/03/2013 10:35:01
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SystemMessageDisplayMessage extends MessageDeserializer {
  val messageId = 189

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SystemMessageDisplayMessage.messageId

    val hangUp: Boolean
    val msgId: Short
    val parameters: Seq[String]

    def serialize(buf: Buffer) {
      buf.writeBoolean(hangUp)
      buf.writeShort(msgId)
      buf.writeUShort(parameters.length)
      for (entry <- parameters) {
        buf.writeString(entry)
      }
    }

  }

  protected def create(hangUp: Boolean, msgId: Short, parameters: Seq[String]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val hangUp = buf.readBoolean()
    val msgId = buf.readShort()
    val parameters = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }

    create(hangUp, msgId, parameters)
  }

}

object SystemMessageDisplayMessage extends SystemMessageDisplayMessage {
  case class MessageImpl(hangUp: Boolean, msgId: Short, parameters: Seq[String]) extends Message
  type Target = MessageImpl

  override def create(hangUp: Boolean, msgId: Short, parameters: Seq[String]) = MessageImpl(hangUp, msgId, parameters)

  def apply(hangUp: Boolean, msgId: Short, parameters: Seq[String]) = create(hangUp, msgId, parameters)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

