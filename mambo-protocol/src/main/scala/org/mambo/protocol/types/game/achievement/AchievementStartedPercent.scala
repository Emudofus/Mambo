




















// Generated on 05/03/2013 10:35:02
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait AchievementStartedPercent extends Achievement {
  override val typeId = 362

  protected trait Type extends Achievement.Type with Serializable {
    override val typeId = AchievementStartedPercent.typeId

    val completionPercent: Byte

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      buf.writeByte(completionPercent)
    }

  }

  protected def create(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl], completionPercent: Byte): Target = throw new IllegalAccessException

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
    val completionPercent = buf.readByte()

    create(id, finishedObjective, startedObjectives, completionPercent)
  }

}

object AchievementStartedPercent extends AchievementStartedPercent {
  case class TypeImpl(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl], completionPercent: Byte) extends Type
  override def create(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl], completionPercent: Byte) = TypeImpl(id, finishedObjective, startedObjectives, completionPercent)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(id: Short, finishedObjective: Seq[AchievementObjective.TypeImpl], startedObjectives: Seq[AchievementStartedObjective.TypeImpl], completionPercent: Byte) = create(id, finishedObjective, startedObjectives, completionPercent)

  type Target = TypeImpl

}

