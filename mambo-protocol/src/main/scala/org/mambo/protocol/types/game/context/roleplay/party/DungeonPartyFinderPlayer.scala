




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait DungeonPartyFinderPlayer extends TypeDeserializer {
  val typeId = 373

  protected trait Type extends BaseType with Serializable {
    val typeId = DungeonPartyFinderPlayer.typeId

    val playerId: Int
    val playerName: String
    val breed: Byte
    val sex: Boolean
    val level: Short

    def serialize(buf: Buffer) {
      buf.writeInt(playerId)
      buf.writeString(playerName)
      buf.writeByte(breed)
      buf.writeBoolean(sex)
      buf.writeShort(level)
    }

  }

  protected def create(playerId: Int, playerName: String, breed: Byte, sex: Boolean, level: Short): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playerId = buf.readInt()
    val playerName = buf.readString()
    val breed = buf.readByte()
    val sex = buf.readBoolean()
    val level = buf.readShort()

    create(playerId, playerName, breed, sex, level)
  }

}

object DungeonPartyFinderPlayer extends DungeonPartyFinderPlayer {
  case class TypeImpl(playerId: Int, playerName: String, breed: Byte, sex: Boolean, level: Short) extends Type
  override def create(playerId: Int, playerName: String, breed: Byte, sex: Boolean, level: Short) = TypeImpl(playerId, playerName, breed, sex, level)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(playerId: Int, playerName: String, breed: Byte, sex: Boolean, level: Short) = create(playerId, playerName, breed, sex, level)

  type Target = TypeImpl

}

