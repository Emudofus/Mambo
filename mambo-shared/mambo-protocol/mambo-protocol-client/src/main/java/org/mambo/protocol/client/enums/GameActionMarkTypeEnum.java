

// Generated on 12/14/2012 18:33:50
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
