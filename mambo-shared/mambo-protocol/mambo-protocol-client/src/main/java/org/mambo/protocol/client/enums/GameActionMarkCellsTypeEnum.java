

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum GameActionMarkCellsTypeEnum {
    CELLS_CIRCLE(0),
    CELLS_CROSS(1);
    
    private int value;
    GameActionMarkCellsTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GameActionMarkCellsTypeEnum valueOf(int value) {
    	for (GameActionMarkCellsTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
