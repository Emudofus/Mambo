

// Generated on 11/11/2012 20:41:42
package org.mambo.protocol.client.enums;

public enum GameActionMarkTypeEnum {
    GLYPH(1),
    TRAP(2),
    WALL(3);
    
    private int value;
    GameActionMarkTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GameActionMarkTypeEnum valueOf(int value) {
    	for (GameActionMarkTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
