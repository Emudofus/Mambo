




















// Generated on 05/03/2013 10:34:39
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait GameFightEndMessage extends MessageDeserializer {
  val messageId = 720

  protected trait Message extends BaseMessage with Serializable {
    val messageId = GameFightEndMessage.messageId

    val duration: Int
    val ageBonus: Short
    val lootShareLimitMalus: Short
    val results: Seq[FightResultListEntry.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(duration)
      buf.writeShort(ageBonus)
      buf.writeShort(lootShareLimitMalus)
      buf.writeUShort(results.length)
      for (entry <- results) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(duration: Int, ageBonus: Short, lootShareLimitMalus: Short, results: Seq[FightResultListEntry.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val duration = buf.readInt()
    val ageBonus = buf.readShort()
    val lootShareLimitMalus = buf.readShort()
    val results = {
      val builder = collection.immutable.Seq.newBuilder[FightResultListEntry.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[FightResultListEntry.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(duration, ageBonus, lootShareLimitMalus, results)
  }

}

object GameFightEndMessage extends GameFightEndMessage {
  case class MessageImpl(duration: Int, ageBonus: Short, lootShareLimitMalus: Short, results: Seq[FightResultListEntry.TypeImpl]) extends Message
  type Target = MessageImpl

  override def create(duration: Int, ageBonus: Short, lootShareLimitMalus: Short, results: Seq[FightResultListEntry.TypeImpl]) = MessageImpl(duration, ageBonus, lootShareLimitMalus, results)

  def apply(duration: Int, ageBonus: Short, lootShareLimitMalus: Short, results: Seq[FightResultListEntry.TypeImpl]) = create(duration, ageBonus, lootShareLimitMalus, results)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

