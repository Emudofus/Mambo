

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum CraftResultEnum {
    CRAFT_IMPOSSIBLE(0),
    CRAFT_FAILED(1),
    CRAFT_SUCCESS(2),
    CRAFT_NEUTRAL(3);
    
    private int value;
    CraftResultEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static CraftResultEnum valueOf(int value) {
    	for (CraftResultEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
