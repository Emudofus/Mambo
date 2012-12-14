

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum GameActionFightInvisibilityStateEnum {
    INVISIBLE(1),
    DETECTED(2),
    VISIBLE(3);
    
    private int value;
    GameActionFightInvisibilityStateEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GameActionFightInvisibilityStateEnum valueOf(int value) {
    	for (GameActionFightInvisibilityStateEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
