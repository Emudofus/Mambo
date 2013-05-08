

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

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
