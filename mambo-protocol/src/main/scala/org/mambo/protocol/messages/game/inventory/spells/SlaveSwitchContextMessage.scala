




















// Generated on 05/03/2013 10:34:58
// Scala version by Blackrush
package org.mambo.protocol.messages

import org.mambo.core.io._
import org.mambo.protocol.{Message => BaseMessage, _}
import org.mambo.protocol.types._
import org.mambo.protocol.enums._

trait SlaveSwitchContextMessage extends MessageDeserializer {
  val messageId = 6214

  protected trait Message extends BaseMessage with Serializable {
    val messageId = SlaveSwitchContextMessage.messageId

    val summonerId: Int
    val slaveId: Int
    val slaveSpells: Seq[SpellItem.TypeImpl]
    val slaveStats: CharacterCharacteristicsInformations.TypeImpl

    def serialize(buf: Buffer) {
      buf.writeInt(summonerId)
      buf.writeInt(slaveId)
      buf.writeUShort(slaveSpells.length)
      for (entry <- slaveSpells) {
        entry.serialize(buf)
      }
      slaveStats.serialize(buf)
    }

  }

  protected def create(summonerId: Int, slaveId: Int, slaveSpells: Seq[SpellItem.TypeImpl], slaveStats: CharacterCharacteristicsInformations.TypeImpl): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val summonerId = buf.readInt()
    val slaveId = buf.readInt()
    val slaveSpells = {
      val builder = collection.immutable.Seq.newBuilder[SpellItem.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += SpellItem.deserialize(buf)
      }
      builder.result()
    }
    val slaveStats = CharacterCharacteristicsInformations.deserialize(buf)

    create(summonerId, slaveId, slaveSpells, slaveStats)
  }

}

object SlaveSwitchContextMessage extends SlaveSwitchContextMessage {
  case class MessageImpl(summonerId: Int, slaveId: Int, slaveSpells: Seq[SpellItem.TypeImpl], slaveStats: CharacterCharacteristicsInformations.TypeImpl) extends Message
  type Target = MessageImpl

  override def create(summonerId: Int, slaveId: Int, slaveSpells: Seq[SpellItem.TypeImpl], slaveStats: CharacterCharacteristicsInformations.TypeImpl) = MessageImpl(summonerId, slaveId, slaveSpells, slaveStats)

  def apply(summonerId: Int, slaveId: Int, slaveSpells: Seq[SpellItem.TypeImpl], slaveStats: CharacterCharacteristicsInformations.TypeImpl) = create(summonerId, slaveId, slaveSpells, slaveStats)
  def unapply(msg: MessageImpl) = MessageImpl.unapply(msg)
}

