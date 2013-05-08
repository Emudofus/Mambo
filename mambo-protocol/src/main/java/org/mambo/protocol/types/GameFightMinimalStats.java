

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightMinimalStats extends NetworkType {
    public static final short TYPE_ID = 31;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(lifePoints);
        buf.writeInt(maxLifePoints);
        buf.writeInt(baseMaxLifePoints);
        buf.writeInt(permanentDamagePercent);
        buf.writeInt(shieldPoints);
        buf.writeShort(actionPoints);
        buf.writeShort(maxActionPoints);
        buf.writeShort(movementPoints);
        buf.writeShort(maxMovementPoints);
        buf.writeInt(summoner);
        buf.writeBoolean(summoned);
        buf.writeShort(neutralElementResistPercent);
        buf.writeShort(earthElementResistPercent);
        buf.writeShort(waterElementResistPercent);
        buf.writeShort(airElementResistPercent);
        buf.writeShort(fireElementResistPercent);
        buf.writeShort(neutralElementReduction);
        buf.writeShort(earthElementReduction);
        buf.writeShort(waterElementReduction);
        buf.writeShort(airElementReduction);
        buf.writeShort(fireElementReduction);
        buf.writeShort(criticalDamageFixedResist);
        buf.writeShort(pushDamageFixedResist);
        buf.writeShort(dodgePALostProbability);
        buf.writeShort(dodgePMLostProbability);
        buf.writeShort(tackleBlock);
        buf.writeShort(tackleEvade);
        buf.writeByte(invisibilityState);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        lifePoints = buf.readInt();
        if (lifePoints < 0)
            throw new RuntimeException("Forbidden value on lifePoints = " + lifePoints + ", it doesn't respect the following condition : lifePoints < 0");
        maxLifePoints = buf.readInt();
        if (maxLifePoints < 0)
            throw new RuntimeException("Forbidden value on maxLifePoints = " + maxLifePoints + ", it doesn't respect the following condition : maxLifePoints < 0");
        baseMaxLifePoints = buf.readInt();
        if (baseMaxLifePoints < 0)
            throw new RuntimeException("Forbidden value on baseMaxLifePoints = " + baseMaxLifePoints + ", it doesn't respect the following condition : baseMaxLifePoints < 0");
        permanentDamagePercent = buf.readInt();
        if (permanentDamagePercent < 0)
            throw new RuntimeException("Forbidden value on permanentDamagePercent = " + permanentDamagePercent + ", it doesn't respect the following condition : permanentDamagePercent < 0");
        shieldPoints = buf.readInt();
        if (shieldPoints < 0)
            throw new RuntimeException("Forbidden value on shieldPoints = " + shieldPoints + ", it doesn't respect the following condition : shieldPoints < 0");
        actionPoints = buf.readShort();
        maxActionPoints = buf.readShort();
        movementPoints = buf.readShort();
        maxMovementPoints = buf.readShort();
        summoner = buf.readInt();
        summoned = buf.readBoolean();
        neutralElementResistPercent = buf.readShort();
        earthElementResistPercent = buf.readShort();
        waterElementResistPercent = buf.readShort();
        airElementResistPercent = buf.readShort();
        fireElementResistPercent = buf.readShort();
        neutralElementReduction = buf.readShort();
        earthElementReduction = buf.readShort();
        waterElementReduction = buf.readShort();
        airElementReduction = buf.readShort();
        fireElementReduction = buf.readShort();
        criticalDamageFixedResist = buf.readShort();
        pushDamageFixedResist = buf.readShort();
        dodgePALostProbability = buf.readShort();
        if (dodgePALostProbability < 0)
            throw new RuntimeException("Forbidden value on dodgePALostProbability = " + dodgePALostProbability + ", it doesn't respect the following condition : dodgePALostProbability < 0");
        dodgePMLostProbability = buf.readShort();
        if (dodgePMLostProbability < 0)
            throw new RuntimeException("Forbidden value on dodgePMLostProbability = " + dodgePMLostProbability + ", it doesn't respect the following condition : dodgePMLostProbability < 0");
        tackleBlock = buf.readShort();
        tackleEvade = buf.readShort();
        invisibilityState = buf.readByte();
    }
    
}
