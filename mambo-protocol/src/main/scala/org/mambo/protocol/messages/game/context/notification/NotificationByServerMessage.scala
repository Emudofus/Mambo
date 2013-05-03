




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NotificationByServerMessage extends MessageDeserializer {
  val messageId = 6103

  protected trait Message extends BaseMessage with Serializable {
    val messageId = NotificationByServerMessage.messageId

    val id: UShort
    val parameters: Seq[String]
    val forceOpen: Boolean

    def serialize(buf: Buffer) {
      buf.writeUShort(id)
      buf.writeUShort(parameters.length)
      for (entry <- parameters) {
        buf.writeString(entry)
      }
      buf.writeBoolean(forceOpen)
    }

  }

  protected def create(id: UShort, parameters: Seq[String], forceOpen: Boolean): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readUShort()
    val parameters = {
      val builder = collection.immutable.Seq.newBuilder[String]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readString()
      }
      builder.result()
    }
    val forceOpen = buf.readBoolean()

    create(id, parameters, forceOpen)
  }

}

object NotificationByServerMessage extends NotificationByServerMessage {
  case class MessageImpl(id: UShort, parameters: Seq[String], forceOpen: Boolean) extends Message
  type Target = MessageImpl

  override def create(id: UShort, parameters: Seq[String], forceOpen: Boolean) = MessageImpl(id, parameters, forceOpen)

  def apply(id: UShort, parameters: Seq[String], forceOpen: Boolean) = create(id, parameters, forceOpen)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

