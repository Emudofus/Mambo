




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait FightResultExperienceData extends FightResultAdditionalData {
  override val typeId = 192

  protected trait Type extends FightResultAdditionalData.Type with Serializable {
    override val typeId = FightResultExperienceData.typeId

    val showExperience: Boolean
    val showExperienceLevelFloor: Boolean
    val showExperienceNextLevelFloor: Boolean
    val showExperienceFightDelta: Boolean
    val showExperienceForGuild: Boolean
    val showExperienceForMount: Boolean
    val isIncarnationExperience: Boolean
    val experience: Double
    val experienceLevelFloor: Double
    val experienceNextLevelFloor: Double
    val experienceFightDelta: Int
    val experienceForGuild: Int
    val experienceForMount: Int
    val rerollExperienceMul: Int

    override def serialize(buf: Buffer) {
      super.serialize(buf)

      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, showExperience)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, showExperienceLevelFloor)
      flag1 = BooleanByteWrapper.setFlag(flag1, 2, showExperienceNextLevelFloor)
      flag1 = BooleanByteWrapper.setFlag(flag1, 3, showExperienceFightDelta)
      flag1 = BooleanByteWrapper.setFlag(flag1, 4, showExperienceForGuild)
      flag1 = BooleanByteWrapper.setFlag(flag1, 5, showExperienceForMount)
      flag1 = BooleanByteWrapper.setFlag(flag1, 6, isIncarnationExperience)
      buf.writeUByte(flag1.toShort)
      buf.writeDouble(experience)
      buf.writeDouble(experienceLevelFloor)
      buf.writeDouble(experienceNextLevelFloor)
      buf.writeInt(experienceFightDelta)
      buf.writeInt(experienceForGuild)
      buf.writeInt(experienceForMount)
      buf.writeInt(rerollExperienceMul)
    }

  }

  protected def create(showExperience: Boolean, showExperienceLevelFloor: Boolean, showExperienceNextLevelFloor: Boolean, showExperienceFightDelta: Boolean, showExperienceForGuild: Boolean, showExperienceForMount: Boolean, isIncarnationExperience: Boolean, experience: Double, experienceLevelFloor: Double, experienceNextLevelFloor: Double, experienceFightDelta: Int, experienceForGuild: Int, experienceForMount: Int, rerollExperienceMul: Int): Target = throw new IllegalAccessException

  override def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val showExperience = BooleanByteWrapper.getFlag(flag1, 0)
    val showExperienceLevelFloor = BooleanByteWrapper.getFlag(flag1, 1)
    val showExperienceNextLevelFloor = BooleanByteWrapper.getFlag(flag1, 2)
    val showExperienceFightDelta = BooleanByteWrapper.getFlag(flag1, 3)
    val showExperienceForGuild = BooleanByteWrapper.getFlag(flag1, 4)
    val showExperienceForMount = BooleanByteWrapper.getFlag(flag1, 5)
    val isIncarnationExperience = BooleanByteWrapper.getFlag(flag1, 6)
    val experience = buf.readDouble()
    val experienceLevelFloor = buf.readDouble()
    val experienceNextLevelFloor = buf.readDouble()
    val experienceFightDelta = buf.readInt()
    val experienceForGuild = buf.readInt()
    val experienceForMount = buf.readInt()
    val rerollExperienceMul = buf.readInt()

    create(showExperience, showExperienceLevelFloor, showExperienceNextLevelFloor, showExperienceFightDelta, showExperienceForGuild, showExperienceForMount, isIncarnationExperience, experience, experienceLevelFloor, experienceNextLevelFloor, experienceFightDelta, experienceForGuild, experienceForMount, rerollExperienceMul)
  }

}

object FightResultExperienceData extends FightResultExperienceData {
  case class TypeImpl(showExperience: Boolean, showExperienceLevelFloor: Boolean, showExperienceNextLevelFloor: Boolean, showExperienceFightDelta: Boolean, showExperienceForGuild: Boolean, showExperienceForMount: Boolean, isIncarnationExperience: Boolean, experience: Double, experienceLevelFloor: Double, experienceNextLevelFloor: Double, experienceFightDelta: Int, experienceForGuild: Int, experienceForMount: Int, rerollExperienceMul: Int) extends Type
  override def create(showExperience: Boolean, showExperienceLevelFloor: Boolean, showExperienceNextLevelFloor: Boolean, showExperienceFightDelta: Boolean, showExperienceForGuild: Boolean, showExperienceForMount: Boolean, isIncarnationExperience: Boolean, experience: Double, experienceLevelFloor: Double, experienceNextLevelFloor: Double, experienceFightDelta: Int, experienceForGuild: Int, experienceForMount: Int, rerollExperienceMul: Int) = TypeImpl(showExperience, showExperienceLevelFloor, showExperienceNextLevelFloor, showExperienceFightDelta, showExperienceForGuild, showExperienceForMount, isIncarnationExperience, experience, experienceLevelFloor, experienceNextLevelFloor, experienceFightDelta, experienceForGuild, experienceForMount, rerollExperienceMul)

  def unapply(msg: TypeImpl) = TypeImpl.unapply(msg)
  def apply(showExperience: Boolean, showExperienceLevelFloor: Boolean, showExperienceNextLevelFloor: Boolean, showExperienceFightDelta: Boolean, showExperienceForGuild: Boolean, showExperienceForMount: Boolean, isIncarnationExperience: Boolean, experience: Double, experienceLevelFloor: Double, experienceNextLevelFloor: Double, experienceFightDelta: Int, experienceForGuild: Int, experienceForMount: Int, rerollExperienceMul: Int) = create(showExperience, showExperienceLevelFloor, showExperienceNextLevelFloor, showExperienceFightDelta, showExperienceForGuild, showExperienceForMount, isIncarnationExperience, experience, experienceLevelFloor, experienceNextLevelFloor, experienceFightDelta, experienceForGuild, experienceForMount, rerollExperienceMul)

  type Target = TypeImpl

}

