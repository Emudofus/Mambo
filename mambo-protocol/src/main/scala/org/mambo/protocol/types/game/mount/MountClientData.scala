




















// Generated on 05/03/2013 10:35:08
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait MountClientData extends TypeDeserializer {
  val typeId = 178

  protected trait Type extends BaseType with Serializable {
    val typeId = MountClientData.typeId

    val sex: Boolean
    val isRideable: Boolean
    val isWild: Boolean
    val isFecondationReady: Boolean
    val id: Double
    val model: Int
    val ancestor: Seq[Int]
    val behaviors: Seq[Int]
    val name: String
    val ownerId: Int
    val experience: Double
    val experienceForLevel: Double
    val experienceForNextLevel: Double
    val level: Byte
    val maxPods: Int
    val stamina: Int
    val staminaMax: Int
    val maturity: Int
    val maturityForAdult: Int
    val energy: Int
    val energyMax: Int
    val serenity: Int
    val aggressivityMax: Int
    val serenityMax: Int
    val love: Int
    val loveMax: Int
    val fecondationTime: Int
    val boostLimiter: Int
    val boostMax: Double
    val reproductionCount: Int
    val reproductionCountMax: Int
    val effectList: Seq[ObjectEffectInteger.TypeImpl]

    def serialize(buf: Buffer) {
      var flag1 = 0
      flag1 = BooleanByteWrapper.setFlag(flag1, 0, sex)
      flag1 = BooleanByteWrapper.setFlag(flag1, 1, isRideable)
      flag1 = BooleanByteWrapper.setFlag(flag1, 2, isWild)
      flag1 = BooleanByteWrapper.setFlag(flag1, 3, isFecondationReady)
      buf.writeUByte(flag1.toShort)
      buf.writeDouble(id)
      buf.writeInt(model)
      buf.writeUShort(ancestor.length)
      for (entry <- ancestor) {
        buf.writeInt(entry)
      }
      buf.writeUShort(behaviors.length)
      for (entry <- behaviors) {
        buf.writeInt(entry)
      }
      buf.writeString(name)
      buf.writeInt(ownerId)
      buf.writeDouble(experience)
      buf.writeDouble(experienceForLevel)
      buf.writeDouble(experienceForNextLevel)
      buf.writeByte(level)
      buf.writeInt(maxPods)
      buf.writeInt(stamina)
      buf.writeInt(staminaMax)
      buf.writeInt(maturity)
      buf.writeInt(maturityForAdult)
      buf.writeInt(energy)
      buf.writeInt(energyMax)
      buf.writeInt(serenity)
      buf.writeInt(aggressivityMax)
      buf.writeInt(serenityMax)
      buf.writeInt(love)
      buf.writeInt(loveMax)
      buf.writeInt(fecondationTime)
      buf.writeInt(boostLimiter)
      buf.writeDouble(boostMax)
      buf.writeInt(reproductionCount)
      buf.writeInt(reproductionCountMax)
      buf.writeUShort(effectList.length)
      for (entry <- effectList) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(sex: Boolean, isRideable: Boolean, isWild: Boolean, isFecondationReady: Boolean, id: Double, model: Int, ancestor: Seq[Int], behaviors: Seq[Int], name: String, ownerId: Int, experience: Double, experienceForLevel: Double, experienceForNextLevel: Double, level: Byte, maxPods: Int, stamina: Int, staminaMax: Int, maturity: Int, maturityForAdult: Int, energy: Int, energyMax: Int, serenity: Int, aggressivityMax: Int, serenityMax: Int, love: Int, loveMax: Int, fecondationTime: Int, boostLimiter: Int, boostMax: Double, reproductionCount: Int, reproductionCountMax: Int, effectList: Seq[ObjectEffectInteger.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val flag1 = buf.readUByte()
    val sex = BooleanByteWrapper.getFlag(flag1, 0)
    val isRideable = BooleanByteWrapper.getFlag(flag1, 1)
    val isWild = BooleanByteWrapper.getFlag(flag1, 2)
    val isFecondationReady = BooleanByteWrapper.getFlag(flag1, 3)
    val id = buf.readDouble()
    val model = buf.readInt()
    val ancestor = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val behaviors = {
      val builder = collection.immutable.Seq.newBuilder[Int]
      for (i <- (0 to buf.readUShort())) {
        builder += buf.readInt()
      }
      builder.result()
    }
    val name = buf.readString()
    val ownerId = buf.readInt()
    val experience = buf.readDouble()
    val experienceForLevel = buf.readDouble()
    val experienceForNextLevel = buf.readDouble()
    val level = buf.readByte()
    val maxPods = buf.readInt()
    val stamina = buf.readInt()
    val staminaMax = buf.readInt()
    val maturity = buf.readInt()
    val maturityForAdult = buf.readInt()
    val energy = buf.readInt()
    val energyMax = buf.readInt()
    val serenity = buf.readInt()
    val aggressivityMax = buf.readInt()
    val serenityMax = buf.readInt()
    val love = buf.readInt()
    val loveMax = buf.readInt()
    val fecondationTime = buf.readInt()
    val boostLimiter = buf.readInt()
    val boostMax = buf.readDouble()
    val reproductionCount = buf.readInt()
    val reproductionCountMax = buf.readInt()
    val effectList = {
      val builder = collection.immutable.Seq.newBuilder[ObjectEffectInteger.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += ObjectEffectInteger.deserialize(buf)
      }
      builder.result()
    }

    create(sex, isRideable, isWild, isFecondationReady, id, model, ancestor, behaviors, name, ownerId, experience, experienceForLevel, experienceForNextLevel, level, maxPods, stamina, staminaMax, maturity, maturityForAdult, energy, energyMax, serenity, aggressivityMax, serenityMax, love, loveMax, fecondationTime, boostLimiter, boostMax, reproductionCount, reproductionCountMax, effectList)
  }

}

object MountClientData extends MountClientData {
  class TypeImpl(val sex: Boolean, val isRideable: Boolean, val isWild: Boolean, val isFecondationReady: Boolean, val id: Double, val model: Int, val ancestor: Seq[Int], val behaviors: Seq[Int], val name: String, val ownerId: Int, val experience: Double, val experienceForLevel: Double, val experienceForNextLevel: Double, val level: Byte, val maxPods: Int, val stamina: Int, val staminaMax: Int, val maturity: Int, val maturityForAdult: Int, val energy: Int, val energyMax: Int, val serenity: Int, val aggressivityMax: Int, val serenityMax: Int, val love: Int, val loveMax: Int, val fecondationTime: Int, val boostLimiter: Int, val boostMax: Double, val reproductionCount: Int, val reproductionCountMax: Int, val effectList: Seq[ObjectEffectInteger.TypeImpl]) extends Type
  override def create(sex: Boolean, isRideable: Boolean, isWild: Boolean, isFecondationReady: Boolean, id: Double, model: Int, ancestor: Seq[Int], behaviors: Seq[Int], name: String, ownerId: Int, experience: Double, experienceForLevel: Double, experienceForNextLevel: Double, level: Byte, maxPods: Int, stamina: Int, staminaMax: Int, maturity: Int, maturityForAdult: Int, energy: Int, energyMax: Int, serenity: Int, aggressivityMax: Int, serenityMax: Int, love: Int, loveMax: Int, fecondationTime: Int, boostLimiter: Int, boostMax: Double, reproductionCount: Int, reproductionCountMax: Int, effectList: Seq[ObjectEffectInteger.TypeImpl]) = new TypeImpl(sex, isRideable, isWild, isFecondationReady, id, model, ancestor, behaviors, name, ownerId, experience, experienceForLevel, experienceForNextLevel, level, maxPods, stamina, staminaMax, maturity, maturityForAdult, energy, energyMax, serenity, aggressivityMax, serenityMax, love, loveMax, fecondationTime, boostLimiter, boostMax, reproductionCount, reproductionCountMax, effectList)

  def apply(sex: Boolean, isRideable: Boolean, isWild: Boolean, isFecondationReady: Boolean, id: Double, model: Int, ancestor: Seq[Int], behaviors: Seq[Int], name: String, ownerId: Int, experience: Double, experienceForLevel: Double, experienceForNextLevel: Double, level: Byte, maxPods: Int, stamina: Int, staminaMax: Int, maturity: Int, maturityForAdult: Int, energy: Int, energyMax: Int, serenity: Int, aggressivityMax: Int, serenityMax: Int, love: Int, loveMax: Int, fecondationTime: Int, boostLimiter: Int, boostMax: Double, reproductionCount: Int, reproductionCountMax: Int, effectList: Seq[ObjectEffectInteger.TypeImpl]) = create(sex, isRideable, isWild, isFecondationReady, id, model, ancestor, behaviors, name, ownerId, experience, experienceForLevel, experienceForNextLevel, level, maxPods, stamina, staminaMax, maturity, maturityForAdult, energy, energyMax, serenity, aggressivityMax, serenityMax, love, loveMax, fecondationTime, boostLimiter, boostMax, reproductionCount, reproductionCountMax, effectList)

  type Target = TypeImpl

}

