

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountClientData extends NetworkType {
    public static final short TYPE_ID = 178;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public boolean sex;
    public boolean isRideable;
    public boolean isWild;
    public boolean isFecondationReady;
    public double id;
    public int model;
    public int[] ancestor;
    public int[] behaviors;
    public String name;
    public int ownerId;
    public double experience;
    public double experienceForLevel;
    public double experienceForNextLevel;
    public byte level;
    public int maxPods;
    public int stamina;
    public int staminaMax;
    public int maturity;
    public int maturityForAdult;
    public int energy;
    public int energyMax;
    public int serenity;
    public int aggressivityMax;
    public int serenityMax;
    public int love;
    public int loveMax;
    public int fecondationTime;
    public int boostLimiter;
    public double boostMax;
    public int reproductionCount;
    public int reproductionCountMax;
    public ObjectEffectInteger[] effectList;
    
    public MountClientData() { }
    
    public MountClientData(boolean sex, boolean isRideable, boolean isWild, boolean isFecondationReady, double id, int model, int[] ancestor, int[] behaviors, String name, int ownerId, double experience, double experienceForLevel, double experienceForNextLevel, byte level, int maxPods, int stamina, int staminaMax, int maturity, int maturityForAdult, int energy, int energyMax, int serenity, int aggressivityMax, int serenityMax, int love, int loveMax, int fecondationTime, int boostLimiter, double boostMax, int reproductionCount, int reproductionCountMax, ObjectEffectInteger[] effectList) {
        this.sex = sex;
        this.isRideable = isRideable;
        this.isWild = isWild;
        this.isFecondationReady = isFecondationReady;
        this.id = id;
        this.model = model;
        this.ancestor = ancestor;
        this.behaviors = behaviors;
        this.name = name;
        this.ownerId = ownerId;
        this.experience = experience;
        this.experienceForLevel = experienceForLevel;
        this.experienceForNextLevel = experienceForNextLevel;
        this.level = level;
        this.maxPods = maxPods;
        this.stamina = stamina;
        this.staminaMax = staminaMax;
        this.maturity = maturity;
        this.maturityForAdult = maturityForAdult;
        this.energy = energy;
        this.energyMax = energyMax;
        this.serenity = serenity;
        this.aggressivityMax = aggressivityMax;
        this.serenityMax = serenityMax;
        this.love = love;
        this.loveMax = loveMax;
        this.fecondationTime = fecondationTime;
        this.boostLimiter = boostLimiter;
        this.boostMax = boostMax;
        this.reproductionCount = reproductionCount;
        this.reproductionCountMax = reproductionCountMax;
        this.effectList = effectList;
    }
    
    @Override
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, sex);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, isRideable);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, isWild);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, isFecondationReady);
        buf.writeUByte(flag1);
        buf.writeDouble(id);
        buf.writeInt(model);
        buf.writeUShort(ancestor.length);
        for (int entry : ancestor) {
            buf.writeInt(entry);
        }
        buf.writeUShort(behaviors.length);
        for (int entry : behaviors) {
            buf.writeInt(entry);
        }
        buf.writeString(name);
        buf.writeInt(ownerId);
        buf.writeDouble(experience);
        buf.writeDouble(experienceForLevel);
        buf.writeDouble(experienceForNextLevel);
        buf.writeByte(level);
        buf.writeInt(maxPods);
        buf.writeInt(stamina);
        buf.writeInt(staminaMax);
        buf.writeInt(maturity);
        buf.writeInt(maturityForAdult);
        buf.writeInt(energy);
        buf.writeInt(energyMax);
        buf.writeInt(serenity);
        buf.writeInt(aggressivityMax);
        buf.writeInt(serenityMax);
        buf.writeInt(love);
        buf.writeInt(loveMax);
        buf.writeInt(fecondationTime);
        buf.writeInt(boostLimiter);
        buf.writeDouble(boostMax);
        buf.writeInt(reproductionCount);
        buf.writeInt(reproductionCountMax);
        buf.writeUShort(effectList.length);
        for (ObjectEffectInteger entry : effectList) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        sex = BooleanByteWrapper.getFlag(flag1, 0);
        isRideable = BooleanByteWrapper.getFlag(flag1, 1);
        isWild = BooleanByteWrapper.getFlag(flag1, 2);
        isFecondationReady = BooleanByteWrapper.getFlag(flag1, 3);
        id = buf.readDouble();
        model = buf.readInt();
        if (model < 0)
            throw new RuntimeException("Forbidden value on model = " + model + ", it doesn't respect the following condition : model < 0");
        int limit = buf.readUShort();
        ancestor = new int[limit];
        for (int i = 0; i < limit; i++) {
            ancestor[i] = buf.readInt();
        }
        limit = buf.readUShort();
        behaviors = new int[limit];
        for (int i = 0; i < limit; i++) {
            behaviors[i] = buf.readInt();
        }
        name = buf.readString();
        ownerId = buf.readInt();
        if (ownerId < 0)
            throw new RuntimeException("Forbidden value on ownerId = " + ownerId + ", it doesn't respect the following condition : ownerId < 0");
        experience = buf.readDouble();
        experienceForLevel = buf.readDouble();
        experienceForNextLevel = buf.readDouble();
        level = buf.readByte();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
        maxPods = buf.readInt();
        if (maxPods < 0)
            throw new RuntimeException("Forbidden value on maxPods = " + maxPods + ", it doesn't respect the following condition : maxPods < 0");
        stamina = buf.readInt();
        if (stamina < 0)
            throw new RuntimeException("Forbidden value on stamina = " + stamina + ", it doesn't respect the following condition : stamina < 0");
        staminaMax = buf.readInt();
        if (staminaMax < 0)
            throw new RuntimeException("Forbidden value on staminaMax = " + staminaMax + ", it doesn't respect the following condition : staminaMax < 0");
        maturity = buf.readInt();
        if (maturity < 0)
            throw new RuntimeException("Forbidden value on maturity = " + maturity + ", it doesn't respect the following condition : maturity < 0");
        maturityForAdult = buf.readInt();
        if (maturityForAdult < 0)
            throw new RuntimeException("Forbidden value on maturityForAdult = " + maturityForAdult + ", it doesn't respect the following condition : maturityForAdult < 0");
        energy = buf.readInt();
        if (energy < 0)
            throw new RuntimeException("Forbidden value on energy = " + energy + ", it doesn't respect the following condition : energy < 0");
        energyMax = buf.readInt();
        if (energyMax < 0)
            throw new RuntimeException("Forbidden value on energyMax = " + energyMax + ", it doesn't respect the following condition : energyMax < 0");
        serenity = buf.readInt();
        aggressivityMax = buf.readInt();
        serenityMax = buf.readInt();
        if (serenityMax < 0)
            throw new RuntimeException("Forbidden value on serenityMax = " + serenityMax + ", it doesn't respect the following condition : serenityMax < 0");
        love = buf.readInt();
        if (love < 0)
            throw new RuntimeException("Forbidden value on love = " + love + ", it doesn't respect the following condition : love < 0");
        loveMax = buf.readInt();
        if (loveMax < 0)
            throw new RuntimeException("Forbidden value on loveMax = " + loveMax + ", it doesn't respect the following condition : loveMax < 0");
        fecondationTime = buf.readInt();
        boostLimiter = buf.readInt();
        if (boostLimiter < 0)
            throw new RuntimeException("Forbidden value on boostLimiter = " + boostLimiter + ", it doesn't respect the following condition : boostLimiter < 0");
        boostMax = buf.readDouble();
        reproductionCount = buf.readInt();
        reproductionCountMax = buf.readInt();
        if (reproductionCountMax < 0)
            throw new RuntimeException("Forbidden value on reproductionCountMax = " + reproductionCountMax + ", it doesn't respect the following condition : reproductionCountMax < 0");
        limit = buf.readUShort();
        effectList = new ObjectEffectInteger[limit];
        for (int i = 0; i < limit; i++) {
            effectList[i] = new ObjectEffectInteger();
            effectList[i].deserialize(buf);
        }
    }
    
}
