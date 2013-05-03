




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait NpcDialogCreationMessage extends MessageDeserializer {
  val messageId = 5618

  protected trait Message extends BaseMessage with Serializable {
    val messageId = NpcDialogCreationMessage.messageId

    val mapId: Int
    val npcId: Int

    def serialize(buf: Buffer) {
      buf.writeInt(mapId)
      buf.writeInt(npcId)
    }

  }

  protected def create(mapId: Int, npcId: Int): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mapId = buf.readInt()
    val npcId = buf.readInt()

    create(mapId, npcId)
  }

}

object NpcDialogCreationMessage extends NpcDialogCreationMessage {
  case class MessageImpl(mapId: Int, npcId: Int) extends Message
  type Target = MessageImpl

  override def create(mapId: Int, npcId: Int) = MessageImpl(mapId, npcId)

  def apply(mapId: Int, npcId: Int) = create(mapId, npcId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

