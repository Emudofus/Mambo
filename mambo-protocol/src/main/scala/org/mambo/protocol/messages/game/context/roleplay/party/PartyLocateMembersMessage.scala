




















// Generated on 05/03/2013 10:34:47
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait PartyLocateMembersMessage extends AbstractPartyMessage {
  override val messageId = 5595

  protected trait Message extends AbstractPartyMessage.Message with Serializable {
    override val messageId = PartyLocateMembersMessage.messageId

    val geopositions: Seq[PartyMemberGeoPosition.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(geopositions.length)
      for (entry <- geopositions) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(partyId: Int, geopositions: Seq[PartyMemberGeoPosition.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val partyId = buf.readInt()
    val geopositions = {
      val builder = collection.immutable.Seq.newBuilder[PartyMemberGeoPosition.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += PartyMemberGeoPosition.deserialize(buf)
      }
      builder.result()
    }

    create(partyId, geopositions)
  }

}

object PartyLocateMembersMessage extends PartyLocateMembersMessage {
  case class MessageImpl(partyId: Int, geopositions: Seq[PartyMemberGeoPosition.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(partyId: Int, geopositions: Seq[PartyMemberGeoPosition.TypeImpl]) = MessageImpl(partyId, geopositions)

  def apply(partyId: Int, geopositions: Seq[PartyMemberGeoPosition.TypeImpl]) = create(partyId, geopositions)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

