




















// Generated on 05/03/2013 10:35:07
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait TaxCollectorFightersInformation extends TypeDeserializer {
  val typeId = 169

  protected trait Type extends BaseType with Serializable {
    val typeId = TaxCollectorFightersInformation.typeId

    val collectorId: Int
    val allyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl]
    val enemyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeInt(collectorId)
      buf.writeUShort(allyCharactersInformations.length)
      for (entry <- allyCharactersInformations) {
        entry.serialize(buf)
      }
      buf.writeUShort(enemyCharactersInformations.length)
      for (entry <- enemyCharactersInformations) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(collectorId: Int, allyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl], enemyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val collectorId = buf.readInt()
    val allyCharactersInformations = {
      val builder = collection.immutable.Seq.newBuilder[CharacterMinimalPlusLookInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterMinimalPlusLookInformations.deserialize(buf)
      }
      builder.result()
    }
    val enemyCharactersInformations = {
      val builder = collection.immutable.Seq.newBuilder[CharacterMinimalPlusLookInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterMinimalPlusLookInformations.deserialize(buf)
      }
      builder.result()
    }

    create(collectorId, allyCharactersInformations, enemyCharactersInformations)
  }

}

object TaxCollectorFightersInformation extends TaxCollectorFightersInformation {
  case class TypeImpl(collectorId: Int, allyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl], enemyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl]) extends Type
  override def create(collectorId: Int, allyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl], enemyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl]) = TypeImpl(collectorId, allyCharactersInformations, enemyCharactersInformations)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(collectorId: Int, allyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl], enemyCharactersInformations: Seq[CharacterMinimalPlusLookInformations.TypeImpl]) = create(collectorId, allyCharactersInformations, enemyCharactersInformations)

  type Target = TypeImpl

}

