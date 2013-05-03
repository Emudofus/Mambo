




















// Generated on 05/03/2013 10:34:57
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LivingObjectMessageRequestMessage extends MessageDeserializer {
  val messageId = 6066

  protected trait Message extends BaseMessage with Serializable {
    val messageId = LivingObjectMessageRequestMessage.messageId

    val msgId: Short
    val parameters: Seq[String]
    val livingObject: UInt

    def serialize(buf: Buffer) {
      buf.writeShort(msgId)
      buf.writeUShort(parameters.length)
      for (entry <- parameters) {
        buf.writeString(entry)
      }
      buf.writeUInt(livingObject)
    }

  }

  protected def create(msgId: Short, parameters: Seq[String], livingObject: UInt): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val msgId = buf.readShort()
    val parameters = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }
    val livingObject = buf.readUInt()

    create(msgId, parameters, livingObject)
  }

}

object LivingObjectMessageRequestMessage extends LivingObjectMessageRequestMessage {
  case class MessageImpl(msgId: Short, parameters: Seq[String], livingObject: UInt) extends Message
  type Target = MessageImpl

  override def create(msgId: Short, parameters: Seq[String], livingObject: UInt) = MessageImpl(msgId, parameters, livingObject)

  def apply(msgId: Short, parameters: Seq[String], livingObject: UInt) = create(msgId, parameters, livingObject)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

