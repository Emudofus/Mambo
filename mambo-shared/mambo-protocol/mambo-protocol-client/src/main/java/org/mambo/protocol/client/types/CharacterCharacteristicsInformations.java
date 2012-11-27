

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterCharacteristicsInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 8;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public double experience;
    public double experienceLevelFloor;
    public double experienceNextLevelFloor;
    public int kamas;
    public int statsPoints;
    public int spellsPoints;
    public ActorExtendedAlignmentInformations alignmentInfos;
    public int lifePoints;
    public int maxLifePoints;
    public short energyPoints;
    public short maxEnergyPoints;
    public short actionPointsCurrent;
    public short movementPointsCurrent;
    public CharacterBaseCharacteristic initiative;
    public CharacterBaseCharacteristic prospecting;
    public CharacterBaseCharacteristic actionPoints;
    public CharacterBaseCharacteristic movementPoints;
    public CharacterBaseCharacteristic strength;
    public CharacterBaseCharacteristic vitality;
    public CharacterBaseCharacteristic wisdom;
    public CharacterBaseCharacteristic chance;
    public CharacterBaseCharacteristic agility;
    public CharacterBaseCharacteristic intelligence;
    public CharacterBaseCharacteristic range;
    public CharacterBaseCharacteristic summonableCreaturesBoost;
    public CharacterBaseCharacteristic reflect;
    public CharacterBaseCharacteristic criticalHit;
    public short criticalHitWeapon;
    public CharacterBaseCharacteristic criticalMiss;
    public CharacterBaseCharacteristic healBonus;
    public CharacterBaseCharacteristic allDamagesBonus;
    public CharacterBaseCharacteristic weaponDamagesBonusPercent;
    public CharacterBaseCharacteristic damagesBonusPercent;
    public CharacterBaseCharacteristic trapBonus;
    public CharacterBaseCharacteristic trapBonusPercent;
    public CharacterBaseCharacteristic permanentDamagePercent;
    public CharacterBaseCharacteristic tackleBlock;
    public CharacterBaseCharacteristic tackleEvade;
    public CharacterBaseCharacteristic PAAttack;
    public CharacterBaseCharacteristic PMAttack;
    public CharacterBaseCharacteristic pushDamageBonus;
    public CharacterBaseCharacteristic criticalDamageBonus;
    public CharacterBaseCharacteristic neutralDamageBonus;
    public CharacterBaseCharacteristic earthDamageBonus;
    public CharacterBaseCharacteristic waterDamageBonus;
    public CharacterBaseCharacteristic airDamageBonus;
    public CharacterBaseCharacteristic fireDamageBonus;
    public CharacterBaseCharacteristic dodgePALostProbability;
    public CharacterBaseCharacteristic dodgePMLostProbability;
    public CharacterBaseCharacteristic neutralElementResistPercent;
    public CharacterBaseCharacteristic earthElementResistPercent;
    public CharacterBaseCharacteristic waterElementResistPercent;
    public CharacterBaseCharacteristic airElementResistPercent;
    public CharacterBaseCharacteristic fireElementResistPercent;
    public CharacterBaseCharacteristic neutralElementReduction;
    public CharacterBaseCharacteristic earthElementReduction;
    public CharacterBaseCharacteristic waterElementReduction;
    public CharacterBaseCharacteristic airElementReduction;
    public CharacterBaseCharacteristic fireElementReduction;
    public CharacterBaseCharacteristic pushDamageReduction;
    public CharacterBaseCharacteristic criticalDamageReduction;
    public CharacterBaseCharacteristic pvpNeutralElementResistPercent;
    public CharacterBaseCharacteristic pvpEarthElementResistPercent;
    public CharacterBaseCharacteristic pvpWaterElementResistPercent;
    public CharacterBaseCharacteristic pvpAirElementResistPercent;
    public CharacterBaseCharacteristic pvpFireElementResistPercent;
    public CharacterBaseCharacteristic pvpNeutralElementReduction;
    public CharacterBaseCharacteristic pvpEarthElementReduction;
    public CharacterBaseCharacteristic pvpWaterElementReduction;
    public CharacterBaseCharacteristic pvpAirElementReduction;
    public CharacterBaseCharacteristic pvpFireElementReduction;
    public CharacterSpellModification[] spellModifications;
    
    public CharacterCharacteristicsInformations() { }
    
    public CharacterCharacteristicsInformations(double experience, double experienceLevelFloor, double experienceNextLevelFloor, int kamas, int statsPoints, int spellsPoints, ActorExtendedAlignmentInformations alignmentInfos, int lifePoints, int maxLifePoints, short energyPoints, short maxEnergyPoints, short actionPointsCurrent, short movementPointsCurrent, CharacterBaseCharacteristic initiative, CharacterBaseCharacteristic prospecting, CharacterBaseCharacteristic actionPoints, CharacterBaseCharacteristic movementPoints, CharacterBaseCharacteristic strength, CharacterBaseCharacteristic vitality, CharacterBaseCharacteristic wisdom, CharacterBaseCharacteristic chance, CharacterBaseCharacteristic agility, CharacterBaseCharacteristic intelligence, CharacterBaseCharacteristic range, CharacterBaseCharacteristic summonableCreaturesBoost, CharacterBaseCharacteristic reflect, CharacterBaseCharacteristic criticalHit, short criticalHitWeapon, CharacterBaseCharacteristic criticalMiss, CharacterBaseCharacteristic healBonus, CharacterBaseCharacteristic allDamagesBonus, CharacterBaseCharacteristic weaponDamagesBonusPercent, CharacterBaseCharacteristic damagesBonusPercent, CharacterBaseCharacteristic trapBonus, CharacterBaseCharacteristic trapBonusPercent, CharacterBaseCharacteristic permanentDamagePercent, CharacterBaseCharacteristic tackleBlock, CharacterBaseCharacteristic tackleEvade, CharacterBaseCharacteristic PAAttack, CharacterBaseCharacteristic PMAttack, CharacterBaseCharacteristic pushDamageBonus, CharacterBaseCharacteristic criticalDamageBonus, CharacterBaseCharacteristic neutralDamageBonus, CharacterBaseCharacteristic earthDamageBonus, CharacterBaseCharacteristic waterDamageBonus, CharacterBaseCharacteristic airDamageBonus, CharacterBaseCharacteristic fireDamageBonus, CharacterBaseCharacteristic dodgePALostProbability, CharacterBaseCharacteristic dodgePMLostProbability, CharacterBaseCharacteristic neutralElementResistPercent, CharacterBaseCharacteristic earthElementResistPercent, CharacterBaseCharacteristic waterElementResistPercent, CharacterBaseCharacteristic airElementResistPercent, CharacterBaseCharacteristic fireElementResistPercent, CharacterBaseCharacteristic neutralElementReduction, CharacterBaseCharacteristic earthElementReduction, CharacterBaseCharacteristic waterElementReduction, CharacterBaseCharacteristic airElementReduction, CharacterBaseCharacteristic fireElementReduction, CharacterBaseCharacteristic pushDamageReduction, CharacterBaseCharacteristic criticalDamageReduction, CharacterBaseCharacteristic pvpNeutralElementResistPercent, CharacterBaseCharacteristic pvpEarthElementResistPercent, CharacterBaseCharacteristic pvpWaterElementResistPercent, CharacterBaseCharacteristic pvpAirElementResistPercent, CharacterBaseCharacteristic pvpFireElementResistPercent, CharacterBaseCharacteristic pvpNeutralElementReduction, CharacterBaseCharacteristic pvpEarthElementReduction, CharacterBaseCharacteristic pvpWaterElementReduction, CharacterBaseCharacteristic pvpAirElementReduction, CharacterBaseCharacteristic pvpFireElementReduction, CharacterSpellModification[] spellModifications) {
        this.experience = experience;
        this.experienceLevelFloor = experienceLevelFloor;
        this.experienceNextLevelFloor = experienceNextLevelFloor;
        this.kamas = kamas;
        this.statsPoints = statsPoints;
        this.spellsPoints = spellsPoints;
        this.alignmentInfos = alignmentInfos;
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
        this.energyPoints = energyPoints;
        this.maxEnergyPoints = maxEnergyPoints;
        this.actionPointsCurrent = actionPointsCurrent;
        this.movementPointsCurrent = movementPointsCurrent;
        this.initiative = initiative;
        this.prospecting = prospecting;
        this.actionPoints = actionPoints;
        this.movementPoints = movementPoints;
        this.strength = strength;
        this.vitality = vitality;
        this.wisdom = wisdom;
        this.chance = chance;
        this.agility = agility;
        this.intelligence = intelligence;
        this.range = range;
        this.summonableCreaturesBoost = summonableCreaturesBoost;
        this.reflect = reflect;
        this.criticalHit = criticalHit;
        this.criticalHitWeapon = criticalHitWeapon;
        this.criticalMiss = criticalMiss;
        this.healBonus = healBonus;
        this.allDamagesBonus = allDamagesBonus;
        this.weaponDamagesBonusPercent = weaponDamagesBonusPercent;
        this.damagesBonusPercent = damagesBonusPercent;
        this.trapBonus = trapBonus;
        this.trapBonusPercent = trapBonusPercent;
        this.permanentDamagePercent = permanentDamagePercent;
        this.tackleBlock = tackleBlock;
        this.tackleEvade = tackleEvade;
        this.PAAttack = PAAttack;
        this.PMAttack = PMAttack;
        this.pushDamageBonus = pushDamageBonus;
        this.criticalDamageBonus = criticalDamageBonus;
        this.neutralDamageBonus = neutralDamageBonus;
        this.earthDamageBonus = earthDamageBonus;
        this.waterDamageBonus = waterDamageBonus;
        this.airDamageBonus = airDamageBonus;
        this.fireDamageBonus = fireDamageBonus;
        this.dodgePALostProbability = dodgePALostProbability;
        this.dodgePMLostProbability = dodgePMLostProbability;
        this.neutralElementResistPercent = neutralElementResistPercent;
        this.earthElementResistPercent = earthElementResistPercent;
        this.waterElementResistPercent = waterElementResistPercent;
        this.airElementResistPercent = airElementResistPercent;
        this.fireElementResistPercent = fireElementResistPercent;
        this.neutralElementReduction = neutralElementReduction;
        this.earthElementReduction = earthElementReduction;
        this.waterElementReduction = waterElementReduction;
        this.airElementReduction = airElementReduction;
        this.fireElementReduction = fireElementReduction;
        this.pushDamageReduction = pushDamageReduction;
        this.criticalDamageReduction = criticalDamageReduction;
        this.pvpNeutralElementResistPercent = pvpNeutralElementResistPercent;
        this.pvpEarthElementResistPercent = pvpEarthElementResistPercent;
        this.pvpWaterElementResistPercent = pvpWaterElementResistPercent;
        this.pvpAirElementResistPercent = pvpAirElementResistPercent;
        this.pvpFireElementResistPercent = pvpFireElementResistPercent;
        this.pvpNeutralElementReduction = pvpNeutralElementReduction;
        this.pvpEarthElementReduction = pvpEarthElementReduction;
        this.pvpWaterElementReduction = pvpWaterElementReduction;
        this.pvpAirElementReduction = pvpAirElementReduction;
        this.pvpFireElementReduction = pvpFireElementReduction;
        this.spellModifications = spellModifications;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(experience);
        writer.writeDouble(experienceLevelFloor);
        writer.writeDouble(experienceNextLevelFloor);
        writer.writeInt(kamas);
        writer.writeInt(statsPoints);
        writer.writeInt(spellsPoints);
        alignmentInfos.serialize(writer);
        writer.writeInt(lifePoints);
        writer.writeInt(maxLifePoints);
        writer.writeShort(energyPoints);
        writer.writeShort(maxEnergyPoints);
        writer.writeShort(actionPointsCurrent);
        writer.writeShort(movementPointsCurrent);
        initiative.serialize(writer);
        prospecting.serialize(writer);
        actionPoints.serialize(writer);
        movementPoints.serialize(writer);
        strength.serialize(writer);
        vitality.serialize(writer);
        wisdom.serialize(writer);
        chance.serialize(writer);
        agility.serialize(writer);
        intelligence.serialize(writer);
        range.serialize(writer);
        summonableCreaturesBoost.serialize(writer);
        reflect.serialize(writer);
        criticalHit.serialize(writer);
        writer.writeShort(criticalHitWeapon);
        criticalMiss.serialize(writer);
        healBonus.serialize(writer);
        allDamagesBonus.serialize(writer);
        weaponDamagesBonusPercent.serialize(writer);
        damagesBonusPercent.serialize(writer);
        trapBonus.serialize(writer);
        trapBonusPercent.serialize(writer);
        permanentDamagePercent.serialize(writer);
        tackleBlock.serialize(writer);
        tackleEvade.serialize(writer);
        PAAttack.serialize(writer);
        PMAttack.serialize(writer);
        pushDamageBonus.serialize(writer);
        criticalDamageBonus.serialize(writer);
        neutralDamageBonus.serialize(writer);
        earthDamageBonus.serialize(writer);
        waterDamageBonus.serialize(writer);
        airDamageBonus.serialize(writer);
        fireDamageBonus.serialize(writer);
        dodgePALostProbability.serialize(writer);
        dodgePMLostProbability.serialize(writer);
        neutralElementResistPercent.serialize(writer);
        earthElementResistPercent.serialize(writer);
        waterElementResistPercent.serialize(writer);
        airElementResistPercent.serialize(writer);
        fireElementResistPercent.serialize(writer);
        neutralElementReduction.serialize(writer);
        earthElementReduction.serialize(writer);
        waterElementReduction.serialize(writer);
        airElementReduction.serialize(writer);
        fireElementReduction.serialize(writer);
        pushDamageReduction.serialize(writer);
        criticalDamageReduction.serialize(writer);
        pvpNeutralElementResistPercent.serialize(writer);
        pvpEarthElementResistPercent.serialize(writer);
        pvpWaterElementResistPercent.serialize(writer);
        pvpAirElementResistPercent.serialize(writer);
        pvpFireElementResistPercent.serialize(writer);
        pvpNeutralElementReduction.serialize(writer);
        pvpEarthElementReduction.serialize(writer);
        pvpWaterElementReduction.serialize(writer);
        pvpAirElementReduction.serialize(writer);
        pvpFireElementReduction.serialize(writer);
        writer.writeUnsignedShort(spellModifications.length);
        for (CharacterSpellModification entry : spellModifications) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        experience = reader.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        experienceLevelFloor = reader.readDouble();
        if (experienceLevelFloor < 0)
            throw new RuntimeException("Forbidden value on experienceLevelFloor = " + experienceLevelFloor + ", it doesn't respect the following condition : experienceLevelFloor < 0");
        experienceNextLevelFloor = reader.readDouble();
        if (experienceNextLevelFloor < 0)
            throw new RuntimeException("Forbidden value on experienceNextLevelFloor = " + experienceNextLevelFloor + ", it doesn't respect the following condition : experienceNextLevelFloor < 0");
        kamas = reader.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
        statsPoints = reader.readInt();
        if (statsPoints < 0)
            throw new RuntimeException("Forbidden value on statsPoints = " + statsPoints + ", it doesn't respect the following condition : statsPoints < 0");
        spellsPoints = reader.readInt();
        if (spellsPoints < 0)
            throw new RuntimeException("Forbidden value on spellsPoints = " + spellsPoints + ", it doesn't respect the following condition : spellsPoints < 0");
        alignmentInfos = new ActorExtendedAlignmentInformations();
        alignmentInfos.deserialize(reader);
        lifePoints = reader.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = reader.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
        energyPoints = reader.readShort();
        if (energyPoints < 0)
            throw new RuntimeException("Forbidden value on energyPoints = " + energyPoints + ", it doesn't respect the following condition : energyPoints < 0");
        maxEnergyPoints = reader.readShort();
        if (maxEnergyPoints < 0)
            throw new RuntimeException("Forbidden value on maxEnergyPoints = " + maxEnergyPoints + ", it doesn't respect the following condition : maxEnergyPoints < 0");
        actionPointsCurrent = reader.readShort();
        movementPointsCurrent = reader.readShort();
        initiative = new CharacterBaseCharacteristic();
        initiative.deserialize(reader);
        prospecting = new CharacterBaseCharacteristic();
        prospecting.deserialize(reader);
        actionPoints = new CharacterBaseCharacteristic();
        actionPoints.deserialize(reader);
        movementPoints = new CharacterBaseCharacteristic();
        movementPoints.deserialize(reader);
        strength = new CharacterBaseCharacteristic();
        strength.deserialize(reader);
        vitality = new CharacterBaseCharacteristic();
        vitality.deserialize(reader);
        wisdom = new CharacterBaseCharacteristic();
        wisdom.deserialize(reader);
        chance = new CharacterBaseCharacteristic();
        chance.deserialize(reader);
        agility = new CharacterBaseCharacteristic();
        agility.deserialize(reader);
        intelligence = new CharacterBaseCharacteristic();
        intelligence.deserialize(reader);
        range = new CharacterBaseCharacteristic();
        range.deserialize(reader);
        summonableCreaturesBoost = new CharacterBaseCharacteristic();
        summonableCreaturesBoost.deserialize(reader);
        reflect = new CharacterBaseCharacteristic();
        reflect.deserialize(reader);
        criticalHit = new CharacterBaseCharacteristic();
        criticalHit.deserialize(reader);
        criticalHitWeapon = reader.readShort();
        if (criticalHitWeapon < 0)
            throw new RuntimeException("Forbidden value on criticalHitWeapon = " + criticalHitWeapon + ", it doesn't respect the following condition : criticalHitWeapon < 0");
        criticalMiss = new CharacterBaseCharacteristic();
        criticalMiss.deserialize(reader);
        healBonus = new CharacterBaseCharacteristic();
        healBonus.deserialize(reader);
        allDamagesBonus = new CharacterBaseCharacteristic();
        allDamagesBonus.deserialize(reader);
        weaponDamagesBonusPercent = new CharacterBaseCharacteristic();
        weaponDamagesBonusPercent.deserialize(reader);
        damagesBonusPercent = new CharacterBaseCharacteristic();
        damagesBonusPercent.deserialize(reader);
        trapBonus = new CharacterBaseCharacteristic();
        trapBonus.deserialize(reader);
        trapBonusPercent = new CharacterBaseCharacteristic();
        trapBonusPercent.deserialize(reader);
        permanentDamagePercent = new CharacterBaseCharacteristic();
        permanentDamagePercent.deserialize(reader);
        tackleBlock = new CharacterBaseCharacteristic();
        tackleBlock.deserialize(reader);
        tackleEvade = new CharacterBaseCharacteristic();
        tackleEvade.deserialize(reader);
        PAAttack = new CharacterBaseCharacteristic();
        PAAttack.deserialize(reader);
        PMAttack = new CharacterBaseCharacteristic();
        PMAttack.deserialize(reader);
        pushDamageBonus = new CharacterBaseCharacteristic();
        pushDamageBonus.deserialize(reader);
        criticalDamageBonus = new CharacterBaseCharacteristic();
        criticalDamageBonus.deserialize(reader);
        neutralDamageBonus = new CharacterBaseCharacteristic();
        neutralDamageBonus.deserialize(reader);
        earthDamageBonus = new CharacterBaseCharacteristic();
        earthDamageBonus.deserialize(reader);
        waterDamageBonus = new CharacterBaseCharacteristic();
        waterDamageBonus.deserialize(reader);
        airDamageBonus = new CharacterBaseCharacteristic();
        airDamageBonus.deserialize(reader);
        fireDamageBonus = new CharacterBaseCharacteristic();
        fireDamageBonus.deserialize(reader);
        dodgePALostProbability = new CharacterBaseCharacteristic();
        dodgePALostProbability.deserialize(reader);
        dodgePMLostProbability = new CharacterBaseCharacteristic();
        dodgePMLostProbability.deserialize(reader);
        neutralElementResistPercent = new CharacterBaseCharacteristic();
        neutralElementResistPercent.deserialize(reader);
        earthElementResistPercent = new CharacterBaseCharacteristic();
        earthElementResistPercent.deserialize(reader);
        waterElementResistPercent = new CharacterBaseCharacteristic();
        waterElementResistPercent.deserialize(reader);
        airElementResistPercent = new CharacterBaseCharacteristic();
        airElementResistPercent.deserialize(reader);
        fireElementResistPercent = new CharacterBaseCharacteristic();
        fireElementResistPercent.deserialize(reader);
        neutralElementReduction = new CharacterBaseCharacteristic();
        neutralElementReduction.deserialize(reader);
        earthElementReduction = new CharacterBaseCharacteristic();
        earthElementReduction.deserialize(reader);
        waterElementReduction = new CharacterBaseCharacteristic();
        waterElementReduction.deserialize(reader);
        airElementReduction = new CharacterBaseCharacteristic();
        airElementReduction.deserialize(reader);
        fireElementReduction = new CharacterBaseCharacteristic();
        fireElementReduction.deserialize(reader);
        pushDamageReduction = new CharacterBaseCharacteristic();
        pushDamageReduction.deserialize(reader);
        criticalDamageReduction = new CharacterBaseCharacteristic();
        criticalDamageReduction.deserialize(reader);
        pvpNeutralElementResistPercent = new CharacterBaseCharacteristic();
        pvpNeutralElementResistPercent.deserialize(reader);
        pvpEarthElementResistPercent = new CharacterBaseCharacteristic();
        pvpEarthElementResistPercent.deserialize(reader);
        pvpWaterElementResistPercent = new CharacterBaseCharacteristic();
        pvpWaterElementResistPercent.deserialize(reader);
        pvpAirElementResistPercent = new CharacterBaseCharacteristic();
        pvpAirElementResistPercent.deserialize(reader);
        pvpFireElementResistPercent = new CharacterBaseCharacteristic();
        pvpFireElementResistPercent.deserialize(reader);
        pvpNeutralElementReduction = new CharacterBaseCharacteristic();
        pvpNeutralElementReduction.deserialize(reader);
        pvpEarthElementReduction = new CharacterBaseCharacteristic();
        pvpEarthElementReduction.deserialize(reader);
        pvpWaterElementReduction = new CharacterBaseCharacteristic();
        pvpWaterElementReduction.deserialize(reader);
        pvpAirElementReduction = new CharacterBaseCharacteristic();
        pvpAirElementReduction.deserialize(reader);
        pvpFireElementReduction = new CharacterBaseCharacteristic();
        pvpFireElementReduction.deserialize(reader);
        int limit = reader.readUnsignedShort();
        spellModifications = new CharacterSpellModification[limit];
        for (int i = 0; i < limit; i++) {
            spellModifications[i] = new CharacterSpellModification();
            spellModifications[i].deserialize(reader);
        }
    }
    
}
