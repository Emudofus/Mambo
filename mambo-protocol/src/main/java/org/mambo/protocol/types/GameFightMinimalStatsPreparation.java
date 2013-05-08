

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightMinimalStatsPreparation extends GameFightMinimalStats {
    public static final short TYPE_ID = 360;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int initiative;
    
    public GameFightMinimalStatsPreparation() { }
    
    public GameFightMinimalStatsPreparation(int lifePoints, int maxLifePoints, int baseMaxLifePoints, int permanentDamagePercent, int shieldPoints, short actionPoints, short maxActionPoints, short movementPoints, short maxMovementPoints, int summoner, boolean summoned, short neutralElementResistPercent, short earthElementResistPercent, short waterElementResistPercent, short airElementResistPercent, short fireElementResistPercent, short neutralElementReduction, short earthElementReduction, short waterElementReduction, short airElementReduction, short fireElementReduction, short criticalDamageFixedResist, short pushDamageFixedResist, short dodgePALostProbability, short dodgePMLostProbability, short tackleBlock, short tackleEvade, byte invisibilityState, int initiative) {
        super(lifePoints, maxLifePoints, baseMaxLifePoints, permanentDamagePercent, shieldPoints, actionPoints, maxActionPoints, movementPoints, maxMovementPoints, summoner, summoned, neutralElementResistPercent, earthElementResistPercent, waterElementResistPercent, airElementResistPercent, fireElementResistPercent, neutralElementReduction, earthElementReduction, waterElementReduction, airElementReduction, fireElementReduction, criticalDamageFixedResist, pushDamageFixedResist, dodgePALostProbability, dodgePMLostProbability, tackleBlock, tackleEvade, invisibilityState);
        this.initiative = initiative;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(initiative);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        initiative = buf.readInt();
        if (initiative < 0)
            throw new RuntimeException("Forbidden value on initiative = " + initiative + ", it doesn't respect the following condition : initiative < 0");
    }
    
}
