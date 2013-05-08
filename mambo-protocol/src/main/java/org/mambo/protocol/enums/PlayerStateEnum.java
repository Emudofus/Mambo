

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum PlayerStateEnum {
    NOT_CONNECTED(0),
    GAME_TYPE_ROLEPLAY(1),
    GAME_TYPE_FIGHT(2),
    UNKNOWN_STATE(99);
    
    private int value;
    PlayerStateEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PlayerStateEnum valueOf(int value) {
    	for (PlayerStateEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
