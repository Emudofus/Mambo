




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GroupMonsterStaticInformationsWithAlternatives extends GroupMonsterStaticInformations {
  override val typeId = 396

  protected trait Type extends GroupMonsterStaticInformations.Type with Serializable {
    override val typeId = GroupMonsterStaticInformationsWithAlternatives.typeId

    val alternatives: Seq[AlternativeMonstersInGroupLightInformations.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeUShort(alternatives.length)
      for (entry <- alternatives) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl, underlings: Seq[MonsterInGroupInformations.TypeImpl], alternatives: Seq[AlternativeMonstersInGroupLightInformations.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val mainCreatureLightInfos = MonsterInGroupLightInformations.deserialize(buf)
    val underlings = {
      val builder = collection.immutable.Seq.newBuilder[MonsterInGroupInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += MonsterInGroupInformations.deserialize(buf)
      }
      builder.result()
    }
    val alternatives = {
      val builder = collection.immutable.Seq.newBuilder[AlternativeMonstersInGroupLightInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += AlternativeMonstersInGroupLightInformations.deserialize(buf)
      }
      builder.result()
    }

    create(mainCreatureLightInfos, underlings, alternatives)
  }

}

object GroupMonsterStaticInformationsWithAlternatives extends GroupMonsterStaticInformationsWithAlternatives {
  case class TypeImpl(mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl, underlings: Seq[MonsterInGroupInformations.TypeImpl], alternatives: Seq[AlternativeMonstersInGroupLightInformations.TypeImpl]) extends Type
  override def create(mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl, underlings: Seq[MonsterInGroupInformations.TypeImpl], alternatives: Seq[AlternativeMonstersInGroupLightInformations.TypeImpl]) = TypeImpl(mainCreatureLightInfos, underlings, alternatives)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(mainCreatureLightInfos: MonsterInGroupLightInformations.TypeImpl, underlings: Seq[MonsterInGroupInformations.TypeImpl], alternatives: Seq[AlternativeMonstersInGroupLightInformations.TypeImpl]) = create(mainCreatureLightInfos, underlings, alternatives)

  type Target = TypeImpl

}

