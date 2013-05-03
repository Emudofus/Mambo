




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait GameRolePlayNpcQuestFlag extends TypeDeserializer {
  val typeId = 384

  protected trait Type extends BaseType with Serializable {
    val typeId = GameRolePlayNpcQuestFlag.typeId

    val questsToValidId: Seq[Short]
    val questsToStartId: Seq[Short]

    def serialize(buf: Buffer) {
      buf.writeUShort(questsToValidId.length)
      for (entry <- questsToValidId) {
        buf.writeShort(entry)
      }
      buf.writeUShort(questsToStartId.length)
      for (entry <- questsToStartId) {
        buf.writeShort(entry)
      }
    }

  }

  protected def create(questsToValidId: Seq[Short], questsToStartId: Seq[Short]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val questsToValidId = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }
    val questsToStartId = {
      val builder = collection.immutable.Seq.newBuilder[Short]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readShort()
      }
      builder.result()
    }

    create(questsToValidId, questsToStartId)
  }

}

object GameRolePlayNpcQuestFlag extends GameRolePlayNpcQuestFlag {
  case class TypeImpl(questsToValidId: Seq[Short], questsToStartId: Seq[Short]) extends Type
  override def create(questsToValidId: Seq[Short], questsToStartId: Seq[Short]) = TypeImpl(questsToValidId, questsToStartId)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(questsToValidId: Seq[Short], questsToStartId: Seq[Short]) = create(questsToValidId, questsToStartId)

  type Target = TypeImpl

}

