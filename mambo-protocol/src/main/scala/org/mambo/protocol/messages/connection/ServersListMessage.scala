




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ServersListMessage extends MessageDeserializer {
  val messageId = 30

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ServersListMessage.messageId

    val servers: Seq[GameServerInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(servers.length)
      for (entry <- servers) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(servers: Seq[GameServerInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val servers = {
      val builder = collection.immutable.Seq.newBuilder[GameServerInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += GameServerInformations.deserialize(buf)
      }
      builder.result()
    }

    create(servers)
  }

}

object ServersListMessage extends ServersListMessage {
  case class MessageImpl(servers: Seq[GameServerInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(servers: Seq[GameServerInformations.TypeImpl]) = MessageImpl(servers)

  def apply(servers: Seq[GameServerInformations.TypeImpl]) = create(servers)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

