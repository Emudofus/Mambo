




















// Generated on 05/03/2013 10:35:05
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait QuestActiveDetailedInformations extends QuestActiveInformations {
  override val typeId = 382

  protected trait Type extends QuestActiveInformations.Type with Serializable {
    override val typeId = QuestActiveDetailedInformations.typeId

    val stepId: Short
    val objectives: Seq[QuestObjectiveInformations.TypeImpl]

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(stepId)
      buf.writeUShort(objectives.length)
      for (entry <- objectives) {
        buf.writeUShort(entry.typeId)
        entry.serialize(buf)
      }
    }

  }

  protected def create(questId: Short, stepId: Short, objectives: Seq[QuestObjectiveInformations.TypeImpl]): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val questId = buf.readShort()
    val stepId = buf.readShort()
    val objectives = {
      val builder = collection.immutable.Seq.newBuilder[QuestObjectiveInformations.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += types.get[QuestObjectiveInformations.TypeImpl](buf.readShort());
      }
      builder.result()
    }

    create(questId, stepId, objectives)
  }

}

object QuestActiveDetailedInformations extends QuestActiveDetailedInformations {
  case class TypeImpl(questId: Short, stepId: Short, objectives: Seq[QuestObjectiveInformations.TypeImpl]) extends Type
  override def create(questId: Short, stepId: Short, objectives: Seq[QuestObjectiveInformations.TypeImpl]) = TypeImpl(questId, stepId, objectives)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(questId: Short, stepId: Short, objectives: Seq[QuestObjectiveInformations.TypeImpl]) = create(questId, stepId, objectives)

  type Target = TypeImpl

}

