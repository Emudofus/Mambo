

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

public enum PvpArenaTypeEnum {
    ARENA_TYPE_3VS3(3),
    ARENA_TYPE_5VS5(5);
    
    private int value;
    PvpArenaTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PvpArenaTypeEnum valueOf(int value) {
    	for (PvpArenaTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
