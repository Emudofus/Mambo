




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GroupMonsterStaticInformations extends TypeDeserializer {
  val typeId = 140

  protected trait Type extends BaseType with Serializable {
    val typeId = GroupMonsterStaticInformations.typeId

    val mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl
    val underlings: Seq[MonsterInGroupInformations.TypeImpl]

    def serialize(buf: Buffer) {
      mainCreatureLightInfos.serialize(buf)
      buf.writeUShort(underlings.length)
      for (entry <- underlings) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl, underlings: Seq[MonsterInGroupInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val mainCreatureLightInfos = MonsterInGroupLightInformations.deserialize(buf)
    val underlings = {
      val builder = collection.immutable.Seq.newBuilder[MonsterInGroupInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MonsterInGroupInformations.deserialize(buf)
      }
      builder.result()
    }

    create(mainCreatureLightInfos, underlings)
  }

}

object GroupMonsterStaticInformations extends GroupMonsterStaticInformations {
  case class TypeImpl(mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl, underlings: Seq[MonsterInGroupInformations.TypeImpl]) extends Type
  override def create(mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl, underlings: Seq[MonsterInGroupInformations.TypeImpl]) = TypeImpl(mainCreatureLightInfos, underlings)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl, underlings: Seq[MonsterInGroupInformations.TypeImpl]) = create(mainCreatureLightInfos, underlings)

  type Target = TypeImpl

}

