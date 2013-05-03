




















// Generated on 05/03/2013 10:34:52
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait TeleportRequestMessage extends MessageDeserializer {
  val messageId = 5961

  protected trait Message extends BaseMessage with Serializable {
    val messageId = TeleportRequestMessage.messageId

    val teleporterType: Byte
    val mapId: Int

    def serialize(buf: Buffer) {
      buf.writeByte(teleporterType)
      buf.writeInt(mapId)
    }

  }

  protected def create(teleporterType: Byte, mapId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val teleporterType = buf.readByte()
    val mapId = buf.readInt()

    create(teleporterType, mapId)
  }

}

object TeleportRequestMessage extends TeleportRequestMessage {
  case class MessageImpl(teleporterType: Byte, mapId: Int) extends Message
  type Target = MessageImpl

  override def create(teleporterType: Byte, mapId: Int) = MessageImpl(teleporterType, mapId)

  def apply(teleporterType: Byte, mapId: Int) = create(teleporterType, mapId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

