




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameFightResumeSlaveInfo extends TypeDeserializer {
  val typeId = 364

  protected trait Type extends BaseType with Serializable {
    val typeId = GameFightResumeSlaveInfo.typeId

    val slaveId: Int
    val spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl]
    val summonCount: Byte
    val bombCount: Byte

    def serialize(buf: Buffer) {
      buf.writeInt(slaveId)
      buf.writeUShort(spellCooldowns.length)
      for (entry <- spellCooldowns) {
        entry.serialize(buf)
      }
      buf.writeByte(summonCount)
      buf.writeByte(bombCount)
    }

  }

  protected def create(slaveId: Int, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val slaveId = buf.readInt()
    val spellCooldowns = {
      val builder = collection.immutable.Seq.newBuilder[GameFightSpellCooldown.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += GameFightSpellCooldown.deserialize(buf)
      }
      builder.result()
    }
    val summonCount = buf.readByte()
    val bombCount = buf.readByte()

    create(slaveId, spellCooldowns, summonCount, bombCount)
  }

}

object GameFightResumeSlaveInfo extends GameFightResumeSlaveInfo {
  case class TypeImpl(slaveId: Int, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte) extends Type
  override def create(slaveId: Int, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte) = TypeImpl(slaveId, spellCooldowns, summonCount, bombCount)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(slaveId: Int, spellCooldowns: Seq[GameFightSpellCooldown.TypeImpl], summonCount: Byte, bombCount: Byte) = create(slaveId, spellCooldowns, summonCount, bombCount)

  type Target = TypeImpl

}

