

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class MountClientData implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 178;
    
    
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
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, sex);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, isRideable);
        flag1 = BooleanByteWrapper.setFlag(flag1, 2, isWild);
        flag1 = BooleanByteWrapper.setFlag(flag1, 3, isFecondationReady);
        writer.writeUnsignedByte(flag1);
        writer.writeDouble(id);
        writer.writeInt(model);
        writer.writeUnsignedShort(ancestor.length);
        for (int entry : ancestor) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedShort(behaviors.length);
        for (int entry : behaviors) {
            writer.writeInt(entry);
        }
        writer.writeString(name);
        writer.writeInt(ownerId);
        writer.writeDouble(experience);
        writer.writeDouble(experienceForLevel);
        writer.writeDouble(experienceForNextLevel);
        writer.writeByte(level);
        writer.writeInt(maxPods);
        writer.writeInt(stamina);
        writer.writeInt(staminaMax);
        writer.writeInt(maturity);
        writer.writeInt(maturityForAdult);
        writer.writeInt(energy);
        writer.writeInt(energyMax);
        writer.writeInt(serenity);
        writer.writeInt(aggressivityMax);
        writer.writeInt(serenityMax);
        writer.writeInt(love);
        writer.writeInt(loveMax);
        writer.writeInt(fecondationTime);
        writer.writeInt(boostLimiter);
        writer.writeDouble(boostMax);
        writer.writeInt(reproductionCount);
        writer.writeInt(reproductionCountMax);
        writer.writeUnsignedShort(effectList.length);
        for (ObjectEffectInteger entry : effectList) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        sex = BooleanByteWrapper.getFlag(flag1, 0);
        isRideable = BooleanByteWrapper.getFlag(flag1, 1);
        isWild = BooleanByteWrapper.getFlag(flag1, 2);
        isFecondationReady = BooleanByteWrapper.getFlag(flag1, 3);
        id = reader.readDouble();
        model = reader.readInt();
        if (model < 0)
            throw new RuntimeException("Forbidden value on model = " + model + ", it doesn't respect the following condition : model < 0");
        int limit = reader.readUnsignedShort();
        ancestor = new int[limit];
        for (int i = 0; i < limit; i++) {
            ancestor[i] = reader.readInt();
        }
        limit = reader.readUnsignedShort();
        behaviors = new int[limit];
        for (int i = 0; i < limit; i++) {
            behaviors[i] = reader.readInt();
        }
        name = reader.readString();
        ownerId = reader.readInt();
        if (ownerId < 0)
            throw new RuntimeException("Forbidden value on ownerId = " + ownerId + ", it doesn't respect the following condition : ownerId < 0");
        experience = reader.readDouble();
        experienceForLevel = reader.readDouble();
        experienceForNextLevel = reader.readDouble();
        level = reader.readByte();
        if (level < 0)
            throw new RuntimeException("Forbidden value on level = " + level + ", it doesn't respect the following condition : level < 0");
        maxPods = reader.readInt();
        if (maxPods < 0)
            throw new RuntimeException("Forbidden value on maxPods = " + maxPods + ", it doesn't respect the following condition : maxPods < 0");
        stamina = reader.readInt();
        if (stamina < 0)
            throw new RuntimeException("Forbidden value on stamina = " + stamina + ", it doesn't respect the following condition : stamina < 0");
        staminaMax = reader.readInt();
        if (staminaMax < 0)
            throw new RuntimeException("Forbidden value on staminaMax = " + staminaMax + ", it doesn't respect the following condition : staminaMax < 0");
        maturity = reader.readInt();
        if (maturity < 0)
            throw new RuntimeException("Forbidden value on maturity = " + maturity + ", it doesn't respect the following condition : maturity < 0");
        maturityForAdult = reader.readInt();
        if (maturityForAdult < 0)
            throw new RuntimeException("Forbidden value on maturityForAdult = " + maturityForAdult + ", it doesn't respect the following condition : maturityForAdult < 0");
        energy = reader.readInt();
        if (energy < 0)
            throw new RuntimeException("Forbidden value on energy = " + energy + ", it doesn't respect the following condition : energy < 0");
        energyMax = reader.readInt();
        if (energyMax < 0)
            throw new RuntimeException("Forbidden value on energyMax = " + energyMax + ", it doesn't respect the following condition : energyMax < 0");
        serenity = reader.readInt();
        aggressivityMax = reader.readInt();
        serenityMax = reader.readInt();
        if (serenityMax < 0)
            throw new RuntimeException("Forbidden value on serenityMax = " + serenityMax + ", it doesn't respect the following condition : serenityMax < 0");
        love = reader.readInt();
        if (love < 0)
            throw new RuntimeException("Forbidden value on love = " + love + ", it doesn't respect the following condition : love < 0");
        loveMax = reader.readInt();
        if (loveMax < 0)
            throw new RuntimeException("Forbidden value on loveMax = " + loveMax + ", it doesn't respect the following condition : loveMax < 0");
        fecondationTime = reader.readInt();
        boostLimiter = reader.readInt();
        if (boostLimiter < 0)
            throw new RuntimeException("Forbidden value on boostLimiter = " + boostLimiter + ", it doesn't respect the following condition : boostLimiter < 0");
        boostMax = reader.readDouble();
        reproductionCount = reader.readInt();
        reproductionCountMax = reader.readInt();
        if (reproductionCountMax < 0)
            throw new RuntimeException("Forbidden value on reproductionCountMax = " + reproductionCountMax + ", it doesn't respect the following condition : reproductionCountMax < 0");
        limit = reader.readUnsignedShort();
        effectList = new ObjectEffectInteger[limit];
        for (int i = 0; i < limit; i++) {
            effectList[i] = new ObjectEffectInteger();
            effectList[i].deserialize(reader);
        }
    }
    
}
