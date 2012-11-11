

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum CharacterSpellModificationTypeEnum {
    INVALID_MODIFICATION(0),
    RANGEABLE(1),
    DAMAGE(2),
    BASE_DAMAGE(3),
    HEAL_BONUS(4),
    AP_COST(5),
    CAST_INTERVAL(6),
    CAST_INTERVAL_SET(7),
    CRITICAL_HIT_BONUS(8),
    CAST_LINE(9),
    LOS(10),
    MAX_CAST_PER_TURN(11),
    MAX_CAST_PER_TARGET(12),
    RANGE(13);
    
    private int value;
    CharacterSpellModificationTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static CharacterSpellModificationTypeEnum valueOf(int value) {
    	for (CharacterSpellModificationTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
