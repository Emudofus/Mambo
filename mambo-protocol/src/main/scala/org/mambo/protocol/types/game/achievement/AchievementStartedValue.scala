




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AchievementStartedValue extends Achievement {
  override val typeId = 361

  protected trait Type extends Achievement.Type with Serializable {
    override val typeId = AchievementStartedValue.typeId

    val value: Short
    val maxValue: Short

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeShort(value)
      buf.writeShort(maxValue)
    }

  }

  protected def create(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl], value: Short, maxValue: Short): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
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
    val value = buf.readShort()
    val maxValue = buf.readShort()

    create(id, finishedObjective, startedObjectives, value, maxValue)
  }

}

object AchievementStartedValue extends AchievementStartedValue {
  case class TypeImpl(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl], value: Short, maxValue: Short) extends Type
  override def create(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl], value: Short, maxValue: Short) = TypeImpl(id, finishedObjective, startedObjectives, value, maxValue)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl], value: Short, maxValue: Short) = create(id, finishedObjective, startedObjectives, value, maxValue)

  type Target = TypeImpl

}

