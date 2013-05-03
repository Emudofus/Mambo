




















// Generated on 05/03/2013 10:34:32
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait AcquaintanceServerListMessage extends MessageDeserializer {
  val messageId = 6142

  protected trait Message extends BaseMessage with Serializable {
    val messageId = AcquaintanceServerListMessage.messageId

    val servers: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(servers.length)
      for (entry <- servers) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(servers: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val servers = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(servers)
  }

}

object AcquaintanceServerListMessage extends AcquaintanceServerListMessage {
  case class MessageImpl(servers: Seq[Short]) extends Message
  type Target = MessageImpl

  override def create(servers: Seq[Short]) = MessageImpl(servers)

  def apply(servers: Seq[Short]) = create(servers)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

