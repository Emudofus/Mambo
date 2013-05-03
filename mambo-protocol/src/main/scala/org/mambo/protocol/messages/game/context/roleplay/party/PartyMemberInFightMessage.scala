




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyMemberInFightMessage extends AbstractPartyMessage {
  override val messageId = 6342

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyMemberInFightMessage.messageId

    val reason: Byte
    val memberId: Int
    val memberAccountId: Int
    val memberName: String
    val fightId: Int
    val fightMap: MapCoordinatesExtended.TypeImpl
    val secondsBeforeFightStart: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(reason)
      buf.writeInt(memberId)
      buf.writeInt(memberAccountId)
      buf.writeString(memberName)
      buf.writeInt(fightId)
      fightMap.serialize(buf)
      buf.writeInt(secondsBeforeFightStart)
    }

  }

  protected def create(partyId: Int, reason: Byte, memberId: Int, memberAccountId: Int, memberName: String, fightId: Int, fightMap: MapCoordinatesExtended.TypeImpl, secondsBeforeFightStart: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val reason = buf.readByte()
    val memberId = buf.readInt()
    val memberAccountId = buf.readInt()
    val memberName = buf.readString()
    val fightId = buf.readInt()
    val fightMap = MapCoordinatesExtended.deserialize(buf)
    val secondsBeforeFightStart = buf.readInt()

    create(partyId, reason, memberId, memberAccountId, memberName, fightId, fightMap, secondsBeforeFightStart)
  }

}

object PartyMemberInFightMessage extends PartyMemberInFightMessage {
  case class MessageImpl(partyId: Int, reason: Byte, memberId: Int, memberAccountId: Int, memberName: String, fightId: Int, fightMap: MapCoordinatesExtended.TypeImpl, secondsBeforeFightStart: Int) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, reason: Byte, memberId: Int, memberAccountId: Int, memberName: String, fightId: Int, fightMap: MapCoordinatesExtended.TypeImpl, secondsBeforeFightStart: Int) = MessageImpl(partyId, reason, memberId, memberAccountId, memberName, fightId, fightMap, secondsBeforeFightStart)

  def apply(partyId: Int, reason: Byte, memberId: Int, memberAccountId: Int, memberName: String, fightId: Int, fightMap: MapCoordinatesExtended.TypeImpl, secondsBeforeFightStart: Int) = create(partyId, reason, memberId, memberAccountId, memberName, fightId, fightMap, secondsBeforeFightStart)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

