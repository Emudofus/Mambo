




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LockableStateUpdateStorageMessage extends LockableStateUpdateAbstractMessage {
  override val messageId = 5669

  protected trait Message extends LockableStateUpdateAbstractMessage.Message with Serializable {
    override val messageId = LockableStateUpdateStorageMessage.messageId

    val mapId: Int
    val elementId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(mapId)
      buf.writeInt(elementId)
    }

  }

  protected def create(locked: Boolean, mapId: Int, elementId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val locked = buf.readBoolean()
    val mapId = buf.readInt()
    val elementId = buf.readInt()

    create(locked, mapId, elementId)
  }

}

object LockableStateUpdateStorageMessage extends LockableStateUpdateStorageMessage {
  case class MessageImpl(locked: Boolean, mapId: Int, elementId: Int) extends Message
  type Target = MessageImpl

  override def create(locked: Boolean, mapId: Int, elementId: Int) = MessageImpl(locked, mapId, elementId)

  def apply(locked: Boolean, mapId: Int, elementId: Int) = create(locked, mapId, elementId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

