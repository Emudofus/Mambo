

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum FightDispellableEnum {
    DISPELLABLE(1),
    DISPELLABLE_BY_DEATH(2),
    DISPELLABLE_BY_STRONG_DISPEL(3),
    REALLY_NOT_DISPELLABLE(4);
    
    private int value;
    FightDispellableEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static FightDispellableEnum valueOf(int value) {
    	for (FightDispellableEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
