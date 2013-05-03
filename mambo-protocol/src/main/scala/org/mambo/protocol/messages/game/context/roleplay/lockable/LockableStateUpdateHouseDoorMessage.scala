




















// Generated on 05/03/2013 10:34:45
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait LockableStateUpdateHouseDoorMessage extends LockableStateUpdateAbstractMessage {
  override val messageId = 5668

  protected trait Message extends LockableStateUpdateAbstractMessage.Message with Serializable {
    override val messageId = LockableStateUpdateHouseDoorMessage.messageId

    val houseId: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(houseId)
    }

  }

  protected def create(locked: Boolean, houseId: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val locked = buf.readBoolean()
    val houseId = buf.readInt()

    create(locked, houseId)
  }

}

object LockableStateUpdateHouseDoorMessage extends LockableStateUpdateHouseDoorMessage {
  case class MessageImpl(locked: Boolean, houseId: Int) extends Message
  type Target = MessageImpl

  override def create(locked: Boolean, houseId: Int) = MessageImpl(locked, houseId)

  def apply(locked: Boolean, houseId: Int) = create(locked, houseId)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

