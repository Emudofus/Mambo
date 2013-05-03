




















// Generated on 05/03/2013 10:34:31
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SelectedServerDataMessage extends MessageDeserializer {
  val messageId = 42

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SelectedServerDataMessage.messageId

    val serverId: Short
    val address: String
    val port: UShort
    val canCreateNewCharacter: Boolean
    val ticket: String

    def serialize(buf: Buffer) {
      buf.writeShort(serverId)
      buf.writeString(address)
      buf.writeUShort(port)
      buf.writeBoolean(canCreateNewCharacter)
      buf.writeString(ticket)
    }

  }

  protected def create(serverId: Short, address: String, port: UShort, canCreateNewCharacter: Boolean, ticket: String): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val serverId = buf.readShort()
    val address = buf.readString()
    val port = buf.readUShort()
    val canCreateNewCharacter = buf.readBoolean()
    val ticket = buf.readString()

    create(serverId, address, port, canCreateNewCharacter, ticket)
  }

}

object SelectedServerDataMessage extends SelectedServerDataMessage {
  case class MessageImpl(serverId: Short, address: String, port: UShort, canCreateNewCharacter: Boolean, ticket: String) extends Message
  type Target = MessageImpl

  override def create(serverId: Short, address: String, port: UShort, canCreateNewCharacter: Boolean, ticket: String) = MessageImpl(serverId, address, port, canCreateNewCharacter, ticket)

  def apply(serverId: Short, address: String, port: UShort, canCreateNewCharacter: Boolean, ticket: String) = create(serverId, address, port, canCreateNewCharacter, ticket)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

