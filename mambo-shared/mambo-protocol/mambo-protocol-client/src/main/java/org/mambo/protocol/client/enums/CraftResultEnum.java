

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.enums;

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
