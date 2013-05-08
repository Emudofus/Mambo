

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterCharacteristicsInformations extends NetworkType {
    public static final short TYPE_ID = 8;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeDouble(experience);
        buf.writeDouble(experienceLevelFloor);
        buf.writeDouble(experienceNextLevelFloor);
        buf.writeInt(kamas);
        buf.writeInt(statsPoints);
        buf.writeInt(spellsPoints);
        alignmentInfos.serialize(buf);
        buf.writeInt(lifePoints);
        buf.writeInt(maxLifePoints);
        buf.writeShort(energyPoints);
        buf.writeShort(maxEnergyPoints);
        buf.writeShort(actionPointsCurrent);
        buf.writeShort(movementPointsCurrent);
        initiative.serialize(buf);
        prospecting.serialize(buf);
        actionPoints.serialize(buf);
        movementPoints.serialize(buf);
        strength.serialize(buf);
        vitality.serialize(buf);
        wisdom.serialize(buf);
        chance.serialize(buf);
        agility.serialize(buf);
        intelligence.serialize(buf);
        range.serialize(buf);
        summonableCreaturesBoost.serialize(buf);
        reflect.serialize(buf);
        criticalHit.serialize(buf);
        buf.writeShort(criticalHitWeapon);
        criticalMiss.serialize(buf);
        healBonus.serialize(buf);
        allDamagesBonus.serialize(buf);
        weaponDamagesBonusPercent.serialize(buf);
        damagesBonusPercent.serialize(buf);
        trapBonus.serialize(buf);
        trapBonusPercent.serialize(buf);
        permanentDamagePercent.serialize(buf);
        tackleBlock.serialize(buf);
        tackleEvade.serialize(buf);
        PAAttack.serialize(buf);
        PMAttack.serialize(buf);
        pushDamageBonus.serialize(buf);
        criticalDamageBonus.serialize(buf);
        neutralDamageBonus.serialize(buf);
        earthDamageBonus.serialize(buf);
        waterDamageBonus.serialize(buf);
        airDamageBonus.serialize(buf);
        fireDamageBonus.serialize(buf);
        dodgePALostProbability.serialize(buf);
        dodgePMLostProbability.serialize(buf);
        neutralElementResistPercent.serialize(buf);
        earthElementResistPercent.serialize(buf);
        waterElementResistPercent.serialize(buf);
        airElementResistPercent.serialize(buf);
        fireElementResistPercent.serialize(buf);
        neutralElementReduction.serialize(buf);
        earthElementReduction.serialize(buf);
        waterElementReduction.serialize(buf);
        airElementReduction.serialize(buf);
        fireElementReduction.serialize(buf);
        pushDamageReduction.serialize(buf);
        criticalDamageReduction.serialize(buf);
        pvpNeutralElementResistPercent.serialize(buf);
        pvpEarthElementResistPercent.serialize(buf);
        pvpWaterElementResistPercent.serialize(buf);
        pvpAirElementResistPercent.serialize(buf);
        pvpFireElementResistPercent.serialize(buf);
        pvpNeutralElementReduction.serialize(buf);
        pvpEarthElementReduction.serialize(buf);
        pvpWaterElementReduction.serialize(buf);
        pvpAirElementReduction.serialize(buf);
        pvpFireElementReduction.serialize(buf);
        buf.writeUShort(spellModifications.length);
        for (CharacterSpellModification entry : spellModifications) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        experience = buf.readDouble();
        if (experience < 0)
            throw new RuntimeException("Forbidden value on experience = " + experience + ", it doesn't respect the following condition : experience < 0");
        experienceLevelFloor = buf.readDouble();
        if (experienceLevelFloor < 0)
            throw new RuntimeException("Forbidden value on experienceLevelFloor = " + experienceLevelFloor + ", it doesn't respect the following condition : experienceLevelFloor < 0");
        experienceNextLevelFloor = buf.readDouble();
        if (experienceNextLevelFloor < 0)
            throw new RuntimeException("Forbidden value on experienceNextLevelFloor = " + experienceNextLevelFloor + ", it doesn't respect the following condition : experienceNextLevelFloor < 0");
        kamas = buf.readInt();
        if (kamas < 0)
            throw new RuntimeException("Forbidden value on kamas = " + kamas + ", it doesn't respect the following condition : kamas < 0");
        statsPoints = buf.readInt();
        if (statsPoints < 0)
            throw new RuntimeException("Forbidden value on statsPoints = " + statsPoints + ", it doesn't respect the following condition : statsPoints < 0");
        spellsPoints = buf.readInt();
        if (spellsPoints < 0)
            throw new RuntimeException("Forbidden value on spellsPoints = " + spellsPoints + ", it doesn't respect the following condition : spellsPoints < 0");
        alignmentInfos = new ActorExtendedAlignmentInformations();
        alignmentInfos.deserialize(buf);
        lifePoints = buf.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = buf.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
        energyPoints = buf.readShort();
        if (energyPoints < 0)
            throw new RuntimeException("Forbidden value on energyPoints = " + energyPoints + ", it doesn't respect the following condition : energyPoints < 0");
        maxEnergyPoints = buf.readShort();
        if (maxEnergyPoints < 0)
            throw new RuntimeException("Forbidden value on maxEnergyPoints = " + maxEnergyPoints + ", it doesn't respect the following condition : maxEnergyPoints < 0");
        actionPointsCurrent = buf.readShort();
        movementPointsCurrent = buf.readShort();
        initiative = new CharacterBaseCharacteristic();
        initiative.deserialize(buf);
        prospecting = new CharacterBaseCharacteristic();
        prospecting.deserialize(buf);
        actionPoints = new CharacterBaseCharacteristic();
        actionPoints.deserialize(buf);
        movementPoints = new CharacterBaseCharacteristic();
        movementPoints.deserialize(buf);
        strength = new CharacterBaseCharacteristic();
        strength.deserialize(buf);
        vitality = new CharacterBaseCharacteristic();
        vitality.deserialize(buf);
        wisdom = new CharacterBaseCharacteristic();
        wisdom.deserialize(buf);
        chance = new CharacterBaseCharacteristic();
        chance.deserialize(buf);
        agility = new CharacterBaseCharacteristic();
        agility.deserialize(buf);
        intelligence = new CharacterBaseCharacteristic();
        intelligence.deserialize(buf);
        range = new CharacterBaseCharacteristic();
        range.deserialize(buf);
        summonableCreaturesBoost = new CharacterBaseCharacteristic();
        summonableCreaturesBoost.deserialize(buf);
        reflect = new CharacterBaseCharacteristic();
        reflect.deserialize(buf);
        criticalHit = new CharacterBaseCharacteristic();
        criticalHit.deserialize(buf);
        criticalHitWeapon = buf.readShort();
        if (criticalHitWeapon < 0)
            throw new RuntimeException("Forbidden value on criticalHitWeapon = " + criticalHitWeapon + ", it doesn't respect the following condition : criticalHitWeapon < 0");
        criticalMiss = new CharacterBaseCharacteristic();
        criticalMiss.deserialize(buf);
        healBonus = new CharacterBaseCharacteristic();
        healBonus.deserialize(buf);
        allDamagesBonus = new CharacterBaseCharacteristic();
        allDamagesBonus.deserialize(buf);
        weaponDamagesBonusPercent = new CharacterBaseCharacteristic();
        weaponDamagesBonusPercent.deserialize(buf);
        damagesBonusPercent = new CharacterBaseCharacteristic();
        damagesBonusPercent.deserialize(buf);
        trapBonus = new CharacterBaseCharacteristic();
        trapBonus.deserialize(buf);
        trapBonusPercent = new CharacterBaseCharacteristic();
        trapBonusPercent.deserialize(buf);
        permanentDamagePercent = new CharacterBaseCharacteristic();
        permanentDamagePercent.deserialize(buf);
        tackleBlock = new CharacterBaseCharacteristic();
        tackleBlock.deserialize(buf);
        tackleEvade = new CharacterBaseCharacteristic();
        tackleEvade.deserialize(buf);
        PAAttack = new CharacterBaseCharacteristic();
        PAAttack.deserialize(buf);
        PMAttack = new CharacterBaseCharacteristic();
        PMAttack.deserialize(buf);
        pushDamageBonus = new CharacterBaseCharacteristic();
        pushDamageBonus.deserialize(buf);
        criticalDamageBonus = new CharacterBaseCharacteristic();
        criticalDamageBonus.deserialize(buf);
        neutralDamageBonus = new CharacterBaseCharacteristic();
        neutralDamageBonus.deserialize(buf);
        earthDamageBonus = new CharacterBaseCharacteristic();
        earthDamageBonus.deserialize(buf);
        waterDamageBonus = new CharacterBaseCharacteristic();
        waterDamageBonus.deserialize(buf);
        airDamageBonus = new CharacterBaseCharacteristic();
        airDamageBonus.deserialize(buf);
        fireDamageBonus = new CharacterBaseCharacteristic();
        fireDamageBonus.deserialize(buf);
        dodgePALostProbability = new CharacterBaseCharacteristic();
        dodgePALostProbability.deserialize(buf);
        dodgePMLostProbability = new CharacterBaseCharacteristic();
        dodgePMLostProbability.deserialize(buf);
        neutralElementResistPercent = new CharacterBaseCharacteristic();
        neutralElementResistPercent.deserialize(buf);
        earthElementResistPercent = new CharacterBaseCharacteristic();
        earthElementResistPercent.deserialize(buf);
        waterElementResistPercent = new CharacterBaseCharacteristic();
        waterElementResistPercent.deserialize(buf);
        airElementResistPercent = new CharacterBaseCharacteristic();
        airElementResistPercent.deserialize(buf);
        fireElementResistPercent = new CharacterBaseCharacteristic();
        fireElementResistPercent.deserialize(buf);
        neutralElementReduction = new CharacterBaseCharacteristic();
        neutralElementReduction.deserialize(buf);
        earthElementReduction = new CharacterBaseCharacteristic();
        earthElementReduction.deserialize(buf);
        waterElementReduction = new CharacterBaseCharacteristic();
        waterElementReduction.deserialize(buf);
        airElementReduction = new CharacterBaseCharacteristic();
        airElementReduction.deserialize(buf);
        fireElementReduction = new CharacterBaseCharacteristic();
        fireElementReduction.deserialize(buf);
        pushDamageReduction = new CharacterBaseCharacteristic();
        pushDamageReduction.deserialize(buf);
        criticalDamageReduction = new CharacterBaseCharacteristic();
        criticalDamageReduction.deserialize(buf);
        pvpNeutralElementResistPercent = new CharacterBaseCharacteristic();
        pvpNeutralElementResistPercent.deserialize(buf);
        pvpEarthElementResistPercent = new CharacterBaseCharacteristic();
        pvpEarthElementResistPercent.deserialize(buf);
        pvpWaterElementResistPercent = new CharacterBaseCharacteristic();
        pvpWaterElementResistPercent.deserialize(buf);
        pvpAirElementResistPercent = new CharacterBaseCharacteristic();
        pvpAirElementResistPercent.deserialize(buf);
        pvpFireElementResistPercent = new CharacterBaseCharacteristic();
        pvpFireElementResistPercent.deserialize(buf);
        pvpNeutralElementReduction = new CharacterBaseCharacteristic();
        pvpNeutralElementReduction.deserialize(buf);
        pvpEarthElementReduction = new CharacterBaseCharacteristic();
        pvpEarthElementReduction.deserialize(buf);
        pvpWaterElementReduction = new CharacterBaseCharacteristic();
        pvpWaterElementReduction.deserialize(buf);
        pvpAirElementReduction = new CharacterBaseCharacteristic();
        pvpAirElementReduction.deserialize(buf);
        pvpFireElementReduction = new CharacterBaseCharacteristic();
        pvpFireElementReduction.deserialize(buf);
        int limit = buf.readUShort();
        spellModifications = new CharacterSpellModification[limit];
        for (int i = 0; i < limit; i++) {
            spellModifications[i] = new CharacterSpellModification();
            spellModifications[i].deserialize(buf);
        }
    }
    
}
