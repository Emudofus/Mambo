




















// Generated on 05/03/2013 10:35:04
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AlternativeMonstersInGroupLightInformations extends TypeDeserializer {
  val typeId = 394

  protected trait Type extends BaseType with Serializable {
    val typeId = AlternativeMonstersInGroupLightInformations.typeId

    val playerCount: Int
    val monsters: Seq[MonsterInGroupLightInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(playerCount)
      buf.writeUShort(monsters.length)
      for (entry <- monsters) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(playerCount: Int, monsters: Seq[MonsterInGroupLightInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val playerCount = buf.readInt()
    val monsters = {
      val builder = collection.immutable.Seq.newBuilder[MonsterInGroupLightInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MonsterInGroupLightInformations.deserialize(buf)
      }
      builder.result()
    }

    create(playerCount, monsters)
  }

}

object AlternativeMonstersInGroupLightInformations extends AlternativeMonstersInGroupLightInformations {
  case class TypeImpl(playerCount: Int, monsters: Seq[MonsterInGroupLightInformations.TypeImpl]) extends Type
  override def create(playerCount: Int, monsters: Seq[MonsterInGroupLightInformations.TypeImpl]) = TypeImpl(playerCount, monsters)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(playerCount: Int, monsters: Seq[MonsterInGroupLightInformations.TypeImpl]) = create(playerCount, monsters)

  type Target = TypeImpl

}

