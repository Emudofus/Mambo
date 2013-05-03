




















// Generated on 05/03/2013 10:34:40
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightSynchronizeMessage extends MessageDeserializer {
  val messageId = 5921

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightSynchronizeMessage.messageId

    val fighters: Seq[GameFightFighterInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeUShort(fighters.length)
      for (entry <- fighters) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(fighters: Seq[GameFightFighterInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val fighters = {
      val builder = collection.immutable.Seq.newBuilder[GameFightFighterInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[GameFightFighterInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(fighters)
  }

}

object GameFightSynchronizeMessage extends GameFightSynchronizeMessage {
  case class MessageImpl(fighters: Seq[GameFightFighterInformations.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(fighters: Seq[GameFightFighterInformations.TypeImpl]) = MessageImpl(fighters)

  def apply(fighters: Seq[GameFightFighterInformations.TypeImpl]) = create(fighters)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

