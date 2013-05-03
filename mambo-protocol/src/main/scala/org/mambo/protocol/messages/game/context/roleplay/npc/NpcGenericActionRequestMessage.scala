




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NpcGenericActionRequestMessage extends MessageDeserializer {
  val messageId = 5898

  protected trait Message extends BaseMessage with Serializable {
    val messageId = NpcGenericActionRequestMessage.messageId

    val npcId: Int
    val npcActionId: Byte
    val npcMapId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(npcId)
      buf.writeByte(npcActionId)
      buf.writeInt(npcMapId)
    }

  }

  protected def create(npcId: Int, npcActionId: Byte, npcMapId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val npcId = buf.readInt()
    val npcActionId = buf.readByte()
    val npcMapId = buf.readInt()

    create(npcId, npcActionId, npcMapId)
  }

}

object NpcGenericActionRequestMessage extends NpcGenericActionRequestMessage {
  case class MessageImpl(npcId: Int, npcActionId: Byte, npcMapId: Int) extends Message
  type Target = MessageImpl

  override def create(npcId: Int, npcActionId: Byte, npcMapId: Int) = MessageImpl(npcId, npcActionId, npcMapId)

  def apply(npcId: Int, npcActionId: Byte, npcMapId: Int) = create(npcId, npcActionId, npcMapId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

