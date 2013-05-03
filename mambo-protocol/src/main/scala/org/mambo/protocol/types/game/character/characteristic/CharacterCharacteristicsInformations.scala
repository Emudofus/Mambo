




















// Generated on 05/03/2013 10:35:03
// Scala version by Blackrush
package org.mambo.protocol.types

import org.mambo.core.io._
import org.mambo.protocol.{Type => BaseType, _}
import org.mambo.protocol.enums._

trait CharacterCharacteristicsInformations extends TypeDeserializer {
  val typeId = 8

  protected trait Type extends BaseType with Serializable {
    val typeId = CharacterCharacteristicsInformations.typeId

    val experience: Double
    val experienceLevelFloor: Double
    val experienceNextLevelFloor: Double
    val kamas: Int
    val statsPoints: Int
    val spellsPoints: Int
    val alignmentInfos: ActorExtendedAlignmentInformations.TypeImpl
    val lifePoints: Int
    val maxLifePoints: Int
    val energyPoints: Short
    val maxEnergyPoints: Short
    val actionPointsCurrent: Short
    val movementPointsCurrent: Short
    val initiative: CharacterBaseCharacteristic.TypeImpl
    val prospecting: CharacterBaseCharacteristic.TypeImpl
    val actionPoints: CharacterBaseCharacteristic.TypeImpl
    val movementPoints: CharacterBaseCharacteristic.TypeImpl
    val strength: CharacterBaseCharacteristic.TypeImpl
    val vitality: CharacterBaseCharacteristic.TypeImpl
    val wisdom: CharacterBaseCharacteristic.TypeImpl
    val chance: CharacterBaseCharacteristic.TypeImpl
    val agility: CharacterBaseCharacteristic.TypeImpl
    val intelligence: CharacterBaseCharacteristic.TypeImpl
    val range: CharacterBaseCharacteristic.TypeImpl
    val summonableCreaturesBoost: CharacterBaseCharacteristic.TypeImpl
    val reflect: CharacterBaseCharacteristic.TypeImpl
    val criticalHit: CharacterBaseCharacteristic.TypeImpl
    val criticalHitWeapon: Short
    val criticalMiss: CharacterBaseCharacteristic.TypeImpl
    val healBonus: CharacterBaseCharacteristic.TypeImpl
    val allDamagesBonus: CharacterBaseCharacteristic.TypeImpl
    val weaponDamagesBonusPercent: CharacterBaseCharacteristic.TypeImpl
    val damagesBonusPercent: CharacterBaseCharacteristic.TypeImpl
    val trapBonus: CharacterBaseCharacteristic.TypeImpl
    val trapBonusPercent: CharacterBaseCharacteristic.TypeImpl
    val permanentDamagePercent: CharacterBaseCharacteristic.TypeImpl
    val tackleBlock: CharacterBaseCharacteristic.TypeImpl
    val tackleEvade: CharacterBaseCharacteristic.TypeImpl
    val PAAttack: CharacterBaseCharacteristic.TypeImpl
    val PMAttack: CharacterBaseCharacteristic.TypeImpl
    val pushDamageBonus: CharacterBaseCharacteristic.TypeImpl
    val criticalDamageBonus: CharacterBaseCharacteristic.TypeImpl
    val neutralDamageBonus: CharacterBaseCharacteristic.TypeImpl
    val earthDamageBonus: CharacterBaseCharacteristic.TypeImpl
    val waterDamageBonus: CharacterBaseCharacteristic.TypeImpl
    val airDamageBonus: CharacterBaseCharacteristic.TypeImpl
    val fireDamageBonus: CharacterBaseCharacteristic.TypeImpl
    val dodgePALostProbability: CharacterBaseCharacteristic.TypeImpl
    val dodgePMLostProbability: CharacterBaseCharacteristic.TypeImpl
    val neutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val earthElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val waterElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val airElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val fireElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val neutralElementReduction: CharacterBaseCharacteristic.TypeImpl
    val earthElementReduction: CharacterBaseCharacteristic.TypeImpl
    val waterElementReduction: CharacterBaseCharacteristic.TypeImpl
    val airElementReduction: CharacterBaseCharacteristic.TypeImpl
    val fireElementReduction: CharacterBaseCharacteristic.TypeImpl
    val pushDamageReduction: CharacterBaseCharacteristic.TypeImpl
    val criticalDamageReduction: CharacterBaseCharacteristic.TypeImpl
    val pvpNeutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val pvpEarthElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val pvpWaterElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val pvpAirElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val pvpFireElementResistPercent: CharacterBaseCharacteristic.TypeImpl
    val pvpNeutralElementReduction: CharacterBaseCharacteristic.TypeImpl
    val pvpEarthElementReduction: CharacterBaseCharacteristic.TypeImpl
    val pvpWaterElementReduction: CharacterBaseCharacteristic.TypeImpl
    val pvpAirElementReduction: CharacterBaseCharacteristic.TypeImpl
    val pvpFireElementReduction: CharacterBaseCharacteristic.TypeImpl
    val spellModifications: Seq[CharacterSpellModification.TypeImpl]

    def serialize(buf: Buffer) {
      buf.writeDouble(experience)
      buf.writeDouble(experienceLevelFloor)
      buf.writeDouble(experienceNextLevelFloor)
      buf.writeInt(kamas)
      buf.writeInt(statsPoints)
      buf.writeInt(spellsPoints)
      alignmentInfos.serialize(buf)
      buf.writeInt(lifePoints)
      buf.writeInt(maxLifePoints)
      buf.writeShort(energyPoints)
      buf.writeShort(maxEnergyPoints)
      buf.writeShort(actionPointsCurrent)
      buf.writeShort(movementPointsCurrent)
      initiative.serialize(buf)
      prospecting.serialize(buf)
      actionPoints.serialize(buf)
      movementPoints.serialize(buf)
      strength.serialize(buf)
      vitality.serialize(buf)
      wisdom.serialize(buf)
      chance.serialize(buf)
      agility.serialize(buf)
      intelligence.serialize(buf)
      range.serialize(buf)
      summonableCreaturesBoost.serialize(buf)
      reflect.serialize(buf)
      criticalHit.serialize(buf)
      buf.writeShort(criticalHitWeapon)
      criticalMiss.serialize(buf)
      healBonus.serialize(buf)
      allDamagesBonus.serialize(buf)
      weaponDamagesBonusPercent.serialize(buf)
      damagesBonusPercent.serialize(buf)
      trapBonus.serialize(buf)
      trapBonusPercent.serialize(buf)
      permanentDamagePercent.serialize(buf)
      tackleBlock.serialize(buf)
      tackleEvade.serialize(buf)
      PAAttack.serialize(buf)
      PMAttack.serialize(buf)
      pushDamageBonus.serialize(buf)
      criticalDamageBonus.serialize(buf)
      neutralDamageBonus.serialize(buf)
      earthDamageBonus.serialize(buf)
      waterDamageBonus.serialize(buf)
      airDamageBonus.serialize(buf)
      fireDamageBonus.serialize(buf)
      dodgePALostProbability.serialize(buf)
      dodgePMLostProbability.serialize(buf)
      neutralElementResistPercent.serialize(buf)
      earthElementResistPercent.serialize(buf)
      waterElementResistPercent.serialize(buf)
      airElementResistPercent.serialize(buf)
      fireElementResistPercent.serialize(buf)
      neutralElementReduction.serialize(buf)
      earthElementReduction.serialize(buf)
      waterElementReduction.serialize(buf)
      airElementReduction.serialize(buf)
      fireElementReduction.serialize(buf)
      pushDamageReduction.serialize(buf)
      criticalDamageReduction.serialize(buf)
      pvpNeutralElementResistPercent.serialize(buf)
      pvpEarthElementResistPercent.serialize(buf)
      pvpWaterElementResistPercent.serialize(buf)
      pvpAirElementResistPercent.serialize(buf)
      pvpFireElementResistPercent.serialize(buf)
      pvpNeutralElementReduction.serialize(buf)
      pvpEarthElementReduction.serialize(buf)
      pvpWaterElementReduction.serialize(buf)
      pvpAirElementReduction.serialize(buf)
      pvpFireElementReduction.serialize(buf)
      buf.writeUShort(spellModifications.length)
      for (entry <- spellModifications) {
        entry.serialize(buf)
      }
    }

  }

  protected def create(experience: Double, experienceLevelFloor: Double, experienceNextLevelFloor: Double, kamas: Int, statsPoints: Int, spellsPoints: Int, alignmentInfos: ActorExtendedAlignmentInformations.TypeImpl, lifePoints: Int, maxLifePoints: Int, energyPoints: Short, maxEnergyPoints: Short, actionPointsCurrent: Short, movementPointsCurrent: Short, initiative: CharacterBaseCharacteristic.TypeImpl, prospecting: CharacterBaseCharacteristic.TypeImpl, actionPoints: CharacterBaseCharacteristic.TypeImpl, movementPoints: CharacterBaseCharacteristic.TypeImpl, strength: CharacterBaseCharacteristic.TypeImpl, vitality: CharacterBaseCharacteristic.TypeImpl, wisdom: CharacterBaseCharacteristic.TypeImpl, chance: CharacterBaseCharacteristic.TypeImpl, agility: CharacterBaseCharacteristic.TypeImpl, intelligence: CharacterBaseCharacteristic.TypeImpl, range: CharacterBaseCharacteristic.TypeImpl, summonableCreaturesBoost: CharacterBaseCharacteristic.TypeImpl, reflect: CharacterBaseCharacteristic.TypeImpl, criticalHit: CharacterBaseCharacteristic.TypeImpl, criticalHitWeapon: Short, criticalMiss: CharacterBaseCharacteristic.TypeImpl, healBonus: CharacterBaseCharacteristic.TypeImpl, allDamagesBonus: CharacterBaseCharacteristic.TypeImpl, weaponDamagesBonusPercent: CharacterBaseCharacteristic.TypeImpl, damagesBonusPercent: CharacterBaseCharacteristic.TypeImpl, trapBonus: CharacterBaseCharacteristic.TypeImpl, trapBonusPercent: CharacterBaseCharacteristic.TypeImpl, permanentDamagePercent: CharacterBaseCharacteristic.TypeImpl, tackleBlock: CharacterBaseCharacteristic.TypeImpl, tackleEvade: CharacterBaseCharacteristic.TypeImpl, PAAttack: CharacterBaseCharacteristic.TypeImpl, PMAttack: CharacterBaseCharacteristic.TypeImpl, pushDamageBonus: CharacterBaseCharacteristic.TypeImpl, criticalDamageBonus: CharacterBaseCharacteristic.TypeImpl, neutralDamageBonus: CharacterBaseCharacteristic.TypeImpl, earthDamageBonus: CharacterBaseCharacteristic.TypeImpl, waterDamageBonus: CharacterBaseCharacteristic.TypeImpl, airDamageBonus: CharacterBaseCharacteristic.TypeImpl, fireDamageBonus: CharacterBaseCharacteristic.TypeImpl, dodgePALostProbability: CharacterBaseCharacteristic.TypeImpl, dodgePMLostProbability: CharacterBaseCharacteristic.TypeImpl, neutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl, earthElementResistPercent: CharacterBaseCharacteristic.TypeImpl, waterElementResistPercent: CharacterBaseCharacteristic.TypeImpl, airElementResistPercent: CharacterBaseCharacteristic.TypeImpl, fireElementResistPercent: CharacterBaseCharacteristic.TypeImpl, neutralElementReduction: CharacterBaseCharacteristic.TypeImpl, earthElementReduction: CharacterBaseCharacteristic.TypeImpl, waterElementReduction: CharacterBaseCharacteristic.TypeImpl, airElementReduction: CharacterBaseCharacteristic.TypeImpl, fireElementReduction: CharacterBaseCharacteristic.TypeImpl, pushDamageReduction: CharacterBaseCharacteristic.TypeImpl, criticalDamageReduction: CharacterBaseCharacteristic.TypeImpl, pvpNeutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpEarthElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpWaterElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpAirElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpFireElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpNeutralElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpEarthElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpWaterElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpAirElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpFireElementReduction: CharacterBaseCharacteristic.TypeImpl, spellModifications: Seq[CharacterSpellModification.TypeImpl]): Target = throw new IllegalAccessException

  def deserialize(buf: Buffer) = {
    val experience = buf.readDouble()
    val experienceLevelFloor = buf.readDouble()
    val experienceNextLevelFloor = buf.readDouble()
    val kamas = buf.readInt()
    val statsPoints = buf.readInt()
    val spellsPoints = buf.readInt()
    val alignmentInfos = ActorExtendedAlignmentInformations.deserialize(buf)
    val lifePoints = buf.readInt()
    val maxLifePoints = buf.readInt()
    val energyPoints = buf.readShort()
    val maxEnergyPoints = buf.readShort()
    val actionPointsCurrent = buf.readShort()
    val movementPointsCurrent = buf.readShort()
    val initiative = CharacterBaseCharacteristic.deserialize(buf)
    val prospecting = CharacterBaseCharacteristic.deserialize(buf)
    val actionPoints = CharacterBaseCharacteristic.deserialize(buf)
    val movementPoints = CharacterBaseCharacteristic.deserialize(buf)
    val strength = CharacterBaseCharacteristic.deserialize(buf)
    val vitality = CharacterBaseCharacteristic.deserialize(buf)
    val wisdom = CharacterBaseCharacteristic.deserialize(buf)
    val chance = CharacterBaseCharacteristic.deserialize(buf)
    val agility = CharacterBaseCharacteristic.deserialize(buf)
    val intelligence = CharacterBaseCharacteristic.deserialize(buf)
    val range = CharacterBaseCharacteristic.deserialize(buf)
    val summonableCreaturesBoost = CharacterBaseCharacteristic.deserialize(buf)
    val reflect = CharacterBaseCharacteristic.deserialize(buf)
    val criticalHit = CharacterBaseCharacteristic.deserialize(buf)
    val criticalHitWeapon = buf.readShort()
    val criticalMiss = CharacterBaseCharacteristic.deserialize(buf)
    val healBonus = CharacterBaseCharacteristic.deserialize(buf)
    val allDamagesBonus = CharacterBaseCharacteristic.deserialize(buf)
    val weaponDamagesBonusPercent = CharacterBaseCharacteristic.deserialize(buf)
    val damagesBonusPercent = CharacterBaseCharacteristic.deserialize(buf)
    val trapBonus = CharacterBaseCharacteristic.deserialize(buf)
    val trapBonusPercent = CharacterBaseCharacteristic.deserialize(buf)
    val permanentDamagePercent = CharacterBaseCharacteristic.deserialize(buf)
    val tackleBlock = CharacterBaseCharacteristic.deserialize(buf)
    val tackleEvade = CharacterBaseCharacteristic.deserialize(buf)
    val PAAttack = CharacterBaseCharacteristic.deserialize(buf)
    val PMAttack = CharacterBaseCharacteristic.deserialize(buf)
    val pushDamageBonus = CharacterBaseCharacteristic.deserialize(buf)
    val criticalDamageBonus = CharacterBaseCharacteristic.deserialize(buf)
    val neutralDamageBonus = CharacterBaseCharacteristic.deserialize(buf)
    val earthDamageBonus = CharacterBaseCharacteristic.deserialize(buf)
    val waterDamageBonus = CharacterBaseCharacteristic.deserialize(buf)
    val airDamageBonus = CharacterBaseCharacteristic.deserialize(buf)
    val fireDamageBonus = CharacterBaseCharacteristic.deserialize(buf)
    val dodgePALostProbability = CharacterBaseCharacteristic.deserialize(buf)
    val dodgePMLostProbability = CharacterBaseCharacteristic.deserialize(buf)
    val neutralElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val earthElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val waterElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val airElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val fireElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val neutralElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val earthElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val waterElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val airElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val fireElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val pushDamageReduction = CharacterBaseCharacteristic.deserialize(buf)
    val criticalDamageReduction = CharacterBaseCharacteristic.deserialize(buf)
    val pvpNeutralElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val pvpEarthElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val pvpWaterElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val pvpAirElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val pvpFireElementResistPercent = CharacterBaseCharacteristic.deserialize(buf)
    val pvpNeutralElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val pvpEarthElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val pvpWaterElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val pvpAirElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val pvpFireElementReduction = CharacterBaseCharacteristic.deserialize(buf)
    val spellModifications = {
      val builder = collection.immutable.Seq.newBuilder[CharacterSpellModification.TypeImpl]
      for (i <- (0 to buf.readUShort())) {
        builder += CharacterSpellModification.deserialize(buf)
      }
      builder.result()
    }

    create(experience, experienceLevelFloor, experienceNextLevelFloor, kamas, statsPoints, spellsPoints, alignmentInfos, lifePoints, maxLifePoints, energyPoints, maxEnergyPoints, actionPointsCurrent, movementPointsCurrent, initiative, prospecting, actionPoints, movementPoints, strength, vitality, wisdom, chance, agility, intelligence, range, summonableCreaturesBoost, reflect, criticalHit, criticalHitWeapon, criticalMiss, healBonus, allDamagesBonus, weaponDamagesBonusPercent, damagesBonusPercent, trapBonus, trapBonusPercent, permanentDamagePercent, tackleBlock, tackleEvade, PAAttack, PMAttack, pushDamageBonus, criticalDamageBonus, neutralDamageBonus, earthDamageBonus, waterDamageBonus, airDamageBonus, fireDamageBonus, dodgePALostProbability, dodgePMLostProbability, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, pushDamageReduction, criticalDamageReduction, pvpNeutralElementResistPercent, pvpEarthElementResistPercent, pvpWaterElementResistPercent, pvpAirElementResistPercent, pvpFireElementResistPercent, pvpNeutralElementReduction, pvpEarthElementReduction, pvpWaterElementReduction, pvpAirElementReduction, pvpFireElementReduction, spellModifications)
  }

}

object CharacterCharacteristicsInformations extends CharacterCharacteristicsInformations {
  class TypeImpl(val experience: Double, val experienceLevelFloor: Double, val experienceNextLevelFloor: Double, val kamas: Int, val statsPoints: Int, val spellsPoints: Int, val alignmentInfos: ActorExtendedAlignmentInformations.TypeImpl, val lifePoints: Int, val maxLifePoints: Int, val energyPoints: Short, val maxEnergyPoints: Short, val actionPointsCurrent: Short, val movementPointsCurrent: Short, val initiative: CharacterBaseCharacteristic.TypeImpl, val prospecting: CharacterBaseCharacteristic.TypeImpl, val actionPoints: CharacterBaseCharacteristic.TypeImpl, val movementPoints: CharacterBaseCharacteristic.TypeImpl, val strength: CharacterBaseCharacteristic.TypeImpl, val vitality: CharacterBaseCharacteristic.TypeImpl, val wisdom: CharacterBaseCharacteristic.TypeImpl, val chance: CharacterBaseCharacteristic.TypeImpl, val agility: CharacterBaseCharacteristic.TypeImpl, val intelligence: CharacterBaseCharacteristic.TypeImpl, val range: CharacterBaseCharacteristic.TypeImpl, val summonableCreaturesBoost: CharacterBaseCharacteristic.TypeImpl, val reflect: CharacterBaseCharacteristic.TypeImpl, val criticalHit: CharacterBaseCharacteristic.TypeImpl, val criticalHitWeapon: Short, val criticalMiss: CharacterBaseCharacteristic.TypeImpl, val healBonus: CharacterBaseCharacteristic.TypeImpl, val allDamagesBonus: CharacterBaseCharacteristic.TypeImpl, val weaponDamagesBonusPercent: CharacterBaseCharacteristic.TypeImpl, val damagesBonusPercent: CharacterBaseCharacteristic.TypeImpl, val trapBonus: CharacterBaseCharacteristic.TypeImpl, val trapBonusPercent: CharacterBaseCharacteristic.TypeImpl, val permanentDamagePercent: CharacterBaseCharacteristic.TypeImpl, val tackleBlock: CharacterBaseCharacteristic.TypeImpl, val tackleEvade: CharacterBaseCharacteristic.TypeImpl, val PAAttack: CharacterBaseCharacteristic.TypeImpl, val PMAttack: CharacterBaseCharacteristic.TypeImpl, val pushDamageBonus: CharacterBaseCharacteristic.TypeImpl, val criticalDamageBonus: CharacterBaseCharacteristic.TypeImpl, val neutralDamageBonus: CharacterBaseCharacteristic.TypeImpl, val earthDamageBonus: CharacterBaseCharacteristic.TypeImpl, val waterDamageBonus: CharacterBaseCharacteristic.TypeImpl, val airDamageBonus: CharacterBaseCharacteristic.TypeImpl, val fireDamageBonus: CharacterBaseCharacteristic.TypeImpl, val dodgePALostProbability: CharacterBaseCharacteristic.TypeImpl, val dodgePMLostProbability: CharacterBaseCharacteristic.TypeImpl, val neutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val earthElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val waterElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val airElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val fireElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val neutralElementReduction: CharacterBaseCharacteristic.TypeImpl, val earthElementReduction: CharacterBaseCharacteristic.TypeImpl, val waterElementReduction: CharacterBaseCharacteristic.TypeImpl, val airElementReduction: CharacterBaseCharacteristic.TypeImpl, val fireElementReduction: CharacterBaseCharacteristic.TypeImpl, val pushDamageReduction: CharacterBaseCharacteristic.TypeImpl, val criticalDamageReduction: CharacterBaseCharacteristic.TypeImpl, val pvpNeutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val pvpEarthElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val pvpWaterElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val pvpAirElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val pvpFireElementResistPercent: CharacterBaseCharacteristic.TypeImpl, val pvpNeutralElementReduction: CharacterBaseCharacteristic.TypeImpl, val pvpEarthElementReduction: CharacterBaseCharacteristic.TypeImpl, val pvpWaterElementReduction: CharacterBaseCharacteristic.TypeImpl, val pvpAirElementReduction: CharacterBaseCharacteristic.TypeImpl, val pvpFireElementReduction: CharacterBaseCharacteristic.TypeImpl, val spellModifications: Seq[CharacterSpellModification.TypeImpl]) extends Type
  override def create(experience: Double, experienceLevelFloor: Double, experienceNextLevelFloor: Double, kamas: Int, statsPoints: Int, spellsPoints: Int, alignmentInfos: ActorExtendedAlignmentInformations.TypeImpl, lifePoints: Int, maxLifePoints: Int, energyPoints: Short, maxEnergyPoints: Short, actionPointsCurrent: Short, movementPointsCurrent: Short, initiative: CharacterBaseCharacteristic.TypeImpl, prospecting: CharacterBaseCharacteristic.TypeImpl, actionPoints: CharacterBaseCharacteristic.TypeImpl, movementPoints: CharacterBaseCharacteristic.TypeImpl, strength: CharacterBaseCharacteristic.TypeImpl, vitality: CharacterBaseCharacteristic.TypeImpl, wisdom: CharacterBaseCharacteristic.TypeImpl, chance: CharacterBaseCharacteristic.TypeImpl, agility: CharacterBaseCharacteristic.TypeImpl, intelligence: CharacterBaseCharacteristic.TypeImpl, range: CharacterBaseCharacteristic.TypeImpl, summonableCreaturesBoost: CharacterBaseCharacteristic.TypeImpl, reflect: CharacterBaseCharacteristic.TypeImpl, criticalHit: CharacterBaseCharacteristic.TypeImpl, criticalHitWeapon: Short, criticalMiss: CharacterBaseCharacteristic.TypeImpl, healBonus: CharacterBaseCharacteristic.TypeImpl, allDamagesBonus: CharacterBaseCharacteristic.TypeImpl, weaponDamagesBonusPercent: CharacterBaseCharacteristic.TypeImpl, damagesBonusPercent: CharacterBaseCharacteristic.TypeImpl, trapBonus: CharacterBaseCharacteristic.TypeImpl, trapBonusPercent: CharacterBaseCharacteristic.TypeImpl, permanentDamagePercent: CharacterBaseCharacteristic.TypeImpl, tackleBlock: CharacterBaseCharacteristic.TypeImpl, tackleEvade: CharacterBaseCharacteristic.TypeImpl, PAAttack: CharacterBaseCharacteristic.TypeImpl, PMAttack: CharacterBaseCharacteristic.TypeImpl, pushDamageBonus: CharacterBaseCharacteristic.TypeImpl, criticalDamageBonus: CharacterBaseCharacteristic.TypeImpl, neutralDamageBonus: CharacterBaseCharacteristic.TypeImpl, earthDamageBonus: CharacterBaseCharacteristic.TypeImpl, waterDamageBonus: CharacterBaseCharacteristic.TypeImpl, airDamageBonus: CharacterBaseCharacteristic.TypeImpl, fireDamageBonus: CharacterBaseCharacteristic.TypeImpl, dodgePALostProbability: CharacterBaseCharacteristic.TypeImpl, dodgePMLostProbability: CharacterBaseCharacteristic.TypeImpl, neutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl, earthElementResistPercent: CharacterBaseCharacteristic.TypeImpl, waterElementResistPercent: CharacterBaseCharacteristic.TypeImpl, airElementResistPercent: CharacterBaseCharacteristic.TypeImpl, fireElementResistPercent: CharacterBaseCharacteristic.TypeImpl, neutralElementReduction: CharacterBaseCharacteristic.TypeImpl, earthElementReduction: CharacterBaseCharacteristic.TypeImpl, waterElementReduction: CharacterBaseCharacteristic.TypeImpl, airElementReduction: CharacterBaseCharacteristic.TypeImpl, fireElementReduction: CharacterBaseCharacteristic.TypeImpl, pushDamageReduction: CharacterBaseCharacteristic.TypeImpl, criticalDamageReduction: CharacterBaseCharacteristic.TypeImpl, pvpNeutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpEarthElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpWaterElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpAirElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpFireElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpNeutralElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpEarthElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpWaterElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpAirElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpFireElementReduction: CharacterBaseCharacteristic.TypeImpl, spellModifications: Seq[CharacterSpellModification.TypeImpl]) = new TypeImpl(experience, experienceLevelFloor, experienceNextLevelFloor, kamas, statsPoints, spellsPoints, alignmentInfos, lifePoints, maxLifePoints, energyPoints, maxEnergyPoints, actionPointsCurrent, movementPointsCurrent, initiative, prospecting, actionPoints, movementPoints, strength, vitality, wisdom, chance, agility, intelligence, range, summonableCreaturesBoost, reflect, criticalHit, criticalHitWeapon, criticalMiss, healBonus, allDamagesBonus, weaponDamagesBonusPercent, damagesBonusPercent, trapBonus, trapBonusPercent, permanentDamagePercent, tackleBlock, tackleEvade, PAAttack, PMAttack, pushDamageBonus, criticalDamageBonus, neutralDamageBonus, earthDamageBonus, waterDamageBonus, airDamageBonus, fireDamageBonus, dodgePALostProbability, dodgePMLostProbability, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, pushDamageReduction, criticalDamageReduction, pvpNeutralElementResistPercent, pvpEarthElementResistPercent, pvpWaterElementResistPercent, pvpAirElementResistPercent, pvpFireElementResistPercent, pvpNeutralElementReduction, pvpEarthElementReduction, pvpWaterElementReduction, pvpAirElementReduction, pvpFireElementReduction, spellModifications)

  def apply(experience: Double, experienceLevelFloor: Double, experienceNextLevelFloor: Double, kamas: Int, statsPoints: Int, spellsPoints: Int, alignmentInfos: ActorExtendedAlignmentInformations.TypeImpl, lifePoints: Int, maxLifePoints: Int, energyPoints: Short, maxEnergyPoints: Short, actionPointsCurrent: Short, movementPointsCurrent: Short, initiative: CharacterBaseCharacteristic.TypeImpl, prospecting: CharacterBaseCharacteristic.TypeImpl, actionPoints: CharacterBaseCharacteristic.TypeImpl, movementPoints: CharacterBaseCharacteristic.TypeImpl, strength: CharacterBaseCharacteristic.TypeImpl, vitality: CharacterBaseCharacteristic.TypeImpl, wisdom: CharacterBaseCharacteristic.TypeImpl, chance: CharacterBaseCharacteristic.TypeImpl, agility: CharacterBaseCharacteristic.TypeImpl, intelligence: CharacterBaseCharacteristic.TypeImpl, range: CharacterBaseCharacteristic.TypeImpl, summonableCreaturesBoost: CharacterBaseCharacteristic.TypeImpl, reflect: CharacterBaseCharacteristic.TypeImpl, criticalHit: CharacterBaseCharacteristic.TypeImpl, criticalHitWeapon: Short, criticalMiss: CharacterBaseCharacteristic.TypeImpl, healBonus: CharacterBaseCharacteristic.TypeImpl, allDamagesBonus: CharacterBaseCharacteristic.TypeImpl, weaponDamagesBonusPercent: CharacterBaseCharacteristic.TypeImpl, damagesBonusPercent: CharacterBaseCharacteristic.TypeImpl, trapBonus: CharacterBaseCharacteristic.TypeImpl, trapBonusPercent: CharacterBaseCharacteristic.TypeImpl, permanentDamagePercent: CharacterBaseCharacteristic.TypeImpl, tackleBlock: CharacterBaseCharacteristic.TypeImpl, tackleEvade: CharacterBaseCharacteristic.TypeImpl, PAAttack: CharacterBaseCharacteristic.TypeImpl, PMAttack: CharacterBaseCharacteristic.TypeImpl, pushDamageBonus: CharacterBaseCharacteristic.TypeImpl, criticalDamageBonus: CharacterBaseCharacteristic.TypeImpl, neutralDamageBonus: CharacterBaseCharacteristic.TypeImpl, earthDamageBonus: CharacterBaseCharacteristic.TypeImpl, waterDamageBonus: CharacterBaseCharacteristic.TypeImpl, airDamageBonus: CharacterBaseCharacteristic.TypeImpl, fireDamageBonus: CharacterBaseCharacteristic.TypeImpl, dodgePALostProbability: CharacterBaseCharacteristic.TypeImpl, dodgePMLostProbability: CharacterBaseCharacteristic.TypeImpl, neutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl, earthElementResistPercent: CharacterBaseCharacteristic.TypeImpl, waterElementResistPercent: CharacterBaseCharacteristic.TypeImpl, airElementResistPercent: CharacterBaseCharacteristic.TypeImpl, fireElementResistPercent: CharacterBaseCharacteristic.TypeImpl, neutralElementReduction: CharacterBaseCharacteristic.TypeImpl, earthElementReduction: CharacterBaseCharacteristic.TypeImpl, waterElementReduction: CharacterBaseCharacteristic.TypeImpl, airElementReduction: CharacterBaseCharacteristic.TypeImpl, fireElementReduction: CharacterBaseCharacteristic.TypeImpl, pushDamageReduction: CharacterBaseCharacteristic.TypeImpl, criticalDamageReduction: CharacterBaseCharacteristic.TypeImpl, pvpNeutralElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpEarthElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpWaterElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpAirElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpFireElementResistPercent: CharacterBaseCharacteristic.TypeImpl, pvpNeutralElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpEarthElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpWaterElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpAirElementReduction: CharacterBaseCharacteristic.TypeImpl, pvpFireElementReduction: CharacterBaseCharacteristic.TypeImpl, spellModifications: Seq[CharacterSpellModification.TypeImpl]) = create(experience, experienceLevelFloor, experienceNextLevelFloor, kamas, statsPoints, spellsPoints, alignmentInfos, lifePoints, maxLifePoints, energyPoints, maxEnergyPoints, actionPointsCurrent, movementPointsCurrent, initiative, prospecting, actionPoints, movementPoints, strength, vitality, wisdom, chance, agility, intelligence, range, summonableCreaturesBoost, reflect, criticalHit, criticalHitWeapon, criticalMiss, healBonus, allDamagesBonus, weaponDamagesBonusPercent, damagesBonusPercent, trapBonus, trapBonusPercent, permanentDamagePercent, tackleBlock, tackleEvade, PAAttack, PMAttack, pushDamageBonus, criticalDamageBonus, neutralDamageBonus, earthDamageBonus, waterDamageBonus, airDamageBonus, fireDamageBonus, dodgePALostProbability, dodgePMLostProbability, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, pushDamageReduction, criticalDamageReduction, pvpNeutralElementResistPercent, pvpEarthElementResistPercent, pvpWaterElementResistPercent, pvpAirElementResistPercent, pvpFireElementResistPercent, pvpNeutralElementReduction, pvpEarthElementReduction, pvpWaterElementReduction, pvpAirElementReduction, pvpFireElementReduction, spellModifications)

  type Target = TypeImpl

}

