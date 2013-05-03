




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait Achievement extends TypeDeserializer {
  val typeId = 363

  protected trait Type extends BaseType with Serializable {
    val typeId = Achievement.typeId

    val id: Short
    val finishedObjective: Seq[AchievementObjective.TypeImpl]
    val startedObjectives: Seq[AchievementStartedObjective.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeShort(id)
      buf.writeUShort(finishedObjective.length)
      for (entry <- finishedObjective) {
        entry.serialize(buf)
      }
      buf.writeUShort(startedObjectives.length)
      for (entry <- startedObjectives) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val id = buf.readShort()
    val finishedObjective = {
      val builder = collection.immutable.Seq.newBuilder[AchievementObjective.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += AchievementObjective.deserialize(buf)
      }
      builder.result()
    }
    val startedObjectives = {
      val builder = collection.immutable.Seq.newBuilder[AchievementStartedObjective.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += AchievementStartedObjective.deserialize(buf)
      }
      builder.result()
    }

    create(id, finishedObjective, startedObjectives)
  }

}

object Achievement extends Achievement {
  case class TypeImpl(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl]) extends Type
  override def create(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl]) = TypeImpl(id, finishedObjective, startedObjectives)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl]) = create(id, finishedObjective, startedObjectives)

  type Target = TypeImpl

}

