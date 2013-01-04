

// Generated on 01/04/2013 14:54:45
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightMinimalStats implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 31;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int lifePoints;
    public int maxLifePoints;
    public int baseMaxLifePoints;
    public int permanentDamagePercent;
    public int shieldPoints;
    public short actionPoints;
    public short maxActionPoints;
    public short movementPoints;
    public short maxMovementPoints;
    public int summoner;
    public boolean summoned;
    public short neutralElementResistPercent;
    public short earthElementResistPercent;
    public short waterElementResistPercent;
    public short airElementResistPercent;
    public short fireElementResistPercent;
    public short neutralElementReduction;
    public short earthElementReduction;
    public short waterElementReduction;
    public short airElementReduction;
    public short fireElementReduction;
    public short criticalDamageFixedResist;
    public short pushDamageFixedResist;
    public short dodgePALostProbability;
    public short dodgePMLostProbability;
    public short tackleBlock;
    public short tackleEvade;
    public byte invisibilityState;
    
    public GameFightMinimalStats() { }
    
    public GameFightMinimalStats(int lifePoints, int maxLifePoints, int baseMaxLifePoints, int permanentDamagePercent, int shieldPoints, short actionPoints, short maxActionPoints, short movementPoints, short maxMovementPoints, int summoner, boolean summoned, short neutralElementResistPercent, short earthElementResistPercent, short waterElementResistPercent, short airElementResistPercent, short fireElementResistPercent, short neutralElementReduction, short earthElementReduction, short waterElementReduction, short airElementReduction, short fireElementReduction, short criticalDamageFixedResist, short pushDamageFixedResist, short dodgePALostProbability, short dodgePMLostProbability, short tackleBlock, short tackleEvade, byte invisibilityState) {
        this.lifePoints = lifePoints;
        this.maxLifePoints = maxLifePoints;
        this.baseMaxLifePoints = baseMaxLifePoints;
        this.permanentDamagePercent = permanentDamagePercent;
        this.shieldPoints = shieldPoints;
        this.actionPoints = actionPoints;
        this.maxActionPoints = maxActionPoints;
        this.movementPoints = movementPoints;
        this.maxMovementPoints = maxMovementPoints;
        this.summoner = summoner;
        this.summoned = summoned;
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
        this.criticalDamageFixedResist = criticalDamageFixedResist;
        this.pushDamageFixedResist = pushDamageFixedResist;
        this.dodgePALostProbability = dodgePALostProbability;
        this.dodgePMLostProbability = dodgePMLostProbability;
        this.tackleBlock = tackleBlock;
        this.tackleEvade = tackleEvade;
        this.invisibilityState = invisibilityState;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(lifePoints);
        writer.writeInt(maxLifePoints);
        writer.writeInt(baseMaxLifePoints);
        writer.writeInt(permanentDamagePercent);
        writer.writeInt(shieldPoints);
        writer.writeShort(actionPoints);
        writer.writeShort(maxActionPoints);
        writer.writeShort(movementPoints);
        writer.writeShort(maxMovementPoints);
        writer.writeInt(summoner);
        writer.writeBoolean(summoned);
        writer.writeShort(neutralElementResistPercent);
        writer.writeShort(earthElementResistPercent);
        writer.writeShort(waterElementResistPercent);
        writer.writeShort(airElementResistPercent);
        writer.writeShort(fireElementResistPercent);
        writer.writeShort(neutralElementReduction);
        writer.writeShort(earthElementReduction);
        writer.writeShort(waterElementReduction);
        writer.writeShort(airElementReduction);
        writer.writeShort(fireElementReduction);
        writer.writeShort(criticalDamageFixedResist);
        writer.writeShort(pushDamageFixedResist);
        writer.writeShort(dodgePALostProbability);
        writer.writeShort(dodgePMLostProbability);
        writer.writeShort(tackleBlock);
        writer.writeShort(tackleEvade);
        writer.writeByte(invisibilityState);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        lifePoints = reader.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = reader.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
        baseMaxLifePoints = reader.readInt();
        if (baseMaxLifePoints < 0)
            throw new RuntimeException("Forbidden value on baseMaxLifePoints = " + baseMaxLifePoints + ", it doesn't respect the following condition : baseMaxLifePoints < 0");
        permanentDamagePercent = reader.readInt();
        if (permanentDamagePercent < 0)
            throw new RuntimeException("Forbidden value on permanentDamagePercent = " + permanentDamagePercent + ", it doesn't respect the following condition : permanentDamagePercent < 0");
        shieldPoints = reader.readInt();
        if (shieldPoints < 0)
            throw new RuntimeException("Forbidden value on shieldPoints = " + shieldPoints + ", it doesn't respect the following condition : shieldPoints < 0");
        actionPoints = reader.readShort();
        maxActionPoints = reader.readShort();
        movementPoints = reader.readShort();
        maxMovementPoints = reader.readShort();
        summoner = reader.readInt();
        summoned = reader.readBoolean();
        neutralElementResistPercent = reader.readShort();
        earthElementResistPercent = reader.readShort();
        waterElementResistPercent = reader.readShort();
        airElementResistPercent = reader.readShort();
        fireElementResistPercent = reader.readShort();
        neutralElementReduction = reader.readShort();
        earthElementReduction = reader.readShort();
        waterElementReduction = reader.readShort();
        airElementReduction = reader.readShort();
        fireElementReduction = reader.readShort();
        criticalDamageFixedResist = reader.readShort();
        pushDamageFixedResist = reader.readShort();
        dodgePALostProbability = reader.readShort();
        if (dodgePALostProbability < 0)
            throw new RuntimeException("Forbidden value on dodgePALostProbability = " + dodgePALostProbability + ", it doesn't respect the following condition : dodgePALostProbability < 0");
        dodgePMLostProbability = reader.readShort();
        if (dodgePMLostProbability < 0)
            throw new RuntimeException("Forbidden value on dodgePMLostProbability = " + dodgePMLostProbability + ", it doesn't respect the following condition : dodgePMLostProbability < 0");
        tackleBlock = reader.readShort();
        tackleEvade = reader.readShort();
        invisibilityState = reader.readByte();
    }
    
}
