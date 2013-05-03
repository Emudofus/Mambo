




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait ServerStatusUpdateMessage extends MessageDeserializer {
  val messageId = 50

  protected trait Message extends BaseMessage with Serializable {
    val messageId = ServerStatusUpdateMessage.messageId

    val server: GameServerInformations.TypeImpl

    def serialize(buf: Buffer) {
      server.serialize(buf)
    }

  }

  protected def create(server: GameServerInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val server = GameServerInformations.deserialize(buf)

    create(server)
  }

}

object ServerStatusUpdateMessage extends ServerStatusUpdateMessage {
  case class MessageImpl(server: GameServerInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(server: GameServerInformations.TypeImpl) = MessageImpl(server)

  def apply(server: GameServerInformations.TypeImpl) = create(server)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

