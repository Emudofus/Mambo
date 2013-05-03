




















// Generated on 05/03/2013 10:34:42
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait MapRunningFightListMessage extends MessageDeserializer {
  val messageId = 5743

  protected trait Message extends BaseMessage with Serializable {
    val messageId = MapRunningFightListMessage.messageId

    val fights: Seq[FightExternalInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(fights.length)
      for (entry <- fights) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(fights: Seq[FightExternalInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fights = {
      val builder = collection.immutable.Seq.newBuilder[FightExternalInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += FightExternalInformations.deserialize(buf)
      }
      builder.result()
    }

    create(fights)
  }

}

object MapRunningFightListMessage extends MapRunningFightListMessage {
  case class MessageImpl(fights: Seq[FightExternalInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(fights: Seq[FightExternalInformations.TypeImpl]) = MessageImpl(fights)

  def apply(fights: Seq[FightExternalInformations.TypeImpl]) = create(fights)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

