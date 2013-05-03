




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait DisplayNumericalValueWithAgeBonusMessage extends DisplayNumericalValueMessage {
  override val messageId = 6361

  protected trait Message extends DisplayNumericalValueMessage.Message with Serializable {
    override val messageId = DisplayNumericalValueWithAgeBonusMessage.messageId

    val valueOfBonus: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(valueOfBonus)
    }

  }

  protected def create(entityId: Int, value: Int, theType: Byte, valueOfBonus: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val entityId = buf.readInt()
    val value = buf.readInt()
    val theType = buf.readByte()
    val valueOfBonus = buf.readInt()

    create(entityId, value, theType, valueOfBonus)
  }

}

object DisplayNumericalValueWithAgeBonusMessage extends DisplayNumericalValueWithAgeBonusMessage {
  case class MessageImpl(entityId: Int, value: Int, theType: Byte, valueOfBonus: Int) extends Message
  type Target = MessageImpl

  override def create(entityId: Int, value: Int, theType: Byte, valueOfBonus: Int) = MessageImpl(entityId, value, theType, valueOfBonus)

  def apply(entityId: Int, value: Int, theType: Byte, valueOfBonus: Int) = create(entityId, value, theType, valueOfBonus)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

