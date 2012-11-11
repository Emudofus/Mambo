

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum FightDispellableEnum {
    DISPELLABLE(1),
    DISPELLABLE_BY_DEATH(2),
    NOT_DISPELLABLE(3);
    
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
