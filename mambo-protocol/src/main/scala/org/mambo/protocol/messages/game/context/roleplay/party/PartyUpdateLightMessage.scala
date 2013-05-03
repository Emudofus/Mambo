




















// Generated on 05/03/2013 10:34:48
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyUpdateLightMessage extends AbstractPartyEventMessage {
  override val messageId = 6054

  protected trait Message extends AbstractPartyEventMessage.Message with Serializable {
    override val messageId = PartyUpdateLightMessage.messageId

    val id: Int
    val lifePoints: Int
    val maxLifePoints: Int
    val prospecting: Short
    val regenRate: UByte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeInt(id)
      buf.writeInt(lifePoints)
      buf.writeInt(maxLifePoints)
      buf.writeShort(prospecting)
      buf.writeUByte(regenRate)
    }

  }

  protected def create(partyId: Int, id: Int, lifePoints: Int, maxLifePoints: Int, prospecting: Short, regenRate: UByte): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val id = buf.readInt()
    val lifePoints = buf.readInt()
    val maxLifePoints = buf.readInt()
    val prospecting = buf.readShort()
    val regenRate = buf.readUByte()

    create(partyId, id, lifePoints, maxLifePoints, prospecting, regenRate)
  }

}

object PartyUpdateLightMessage extends PartyUpdateLightMessage {
  case class MessageImpl(partyId: Int, id: Int, lifePoints: Int, maxLifePoints: Int, prospecting: Short, regenRate: UByte) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, id: Int, lifePoints: Int, maxLifePoints: Int, prospecting: Short, regenRate: UByte) = MessageImpl(partyId, id, lifePoints, maxLifePoints, prospecting, regenRate)

  def apply(partyId: Int, id: Int, lifePoints: Int, maxLifePoints: Int, prospecting: Short, regenRate: UByte) = create(partyId, id, lifePoints, maxLifePoints, prospecting, regenRate)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

