

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum FightSpellCastCriticalEnum {
    NORMAL(1),
    CRITICAL_HIT(2),
    CRITICAL_FAIL(3);
    
    private int value;
    FightSpellCastCriticalEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static FightSpellCastCriticalEnum valueOf(int value) {
    	for (FightSpellCastCriticalEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
