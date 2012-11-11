

// Generated on 11/11/2012 20:41:44
package org.mambo.protocol.client.enums;

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
