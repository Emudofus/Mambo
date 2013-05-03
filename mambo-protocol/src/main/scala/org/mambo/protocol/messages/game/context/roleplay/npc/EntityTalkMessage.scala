




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait EntityTalkMessage extends MessageDeserializer {
  val messageId = 6110

  protected trait Message extends BaseMessage with Serializable {
    val messageId = EntityTalkMessage.messageId

    val entityId: Int
    val textId: Short
    val parameters: Seq[String]

    def serialize(buf: Buffer) {
      buf.writeInt(entityId)
      buf.writeShort(textId)
      buf.writeUShort(parameters.length)
      for (entry <- parameters) {
        buf.writeString(entry)
      }
    }

  }

  protected def create(entityId: Int, textId: Short, parameters: Seq[String]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val entityId = buf.readInt()
    val textId = buf.readShort()
    val parameters = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }

    create(entityId, textId, parameters)
  }

}

object EntityTalkMessage extends EntityTalkMessage {
  case class MessageImpl(entityId: Int, textId: Short, parameters: Seq[String]) extends Message
  type Target = MessageImpl

  override def create(entityId: Int, textId: Short, parameters: Seq[String]) = MessageImpl(entityId, textId, parameters)

  def apply(entityId: Int, textId: Short, parameters: Seq[String]) = create(entityId, textId, parameters)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

