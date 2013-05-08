

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum FightTypeEnum {
    FIGHT_TYPE_CHALLENGE(0),
    FIGHT_TYPE_AGRESSION(1),
    FIGHT_TYPE_PvMA(2),
    FIGHT_TYPE_MXvM(3),
    FIGHT_TYPE_PvM(4),
    FIGHT_TYPE_PvT(5),
    FIGHT_TYPE_PvMU(6),
    FIGHT_TYPE_PVP_ARENA(7);
    
    private int value;
    FightTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static FightTypeEnum valueOf(int value) {
    	for (FightTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
