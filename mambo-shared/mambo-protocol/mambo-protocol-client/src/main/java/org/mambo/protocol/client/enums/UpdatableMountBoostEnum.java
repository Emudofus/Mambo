

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum UpdatableMountBoostEnum {
    STAMINA(3),
    MATURITY(5),
    ENERGY(1),
    SERENITY(2),
    LOVE(4),
    TIREDNESS(6);
    
    private int value;
    UpdatableMountBoostEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static UpdatableMountBoostEnum valueOf(int value) {
    	for (UpdatableMountBoostEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
