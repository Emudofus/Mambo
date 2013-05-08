

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

public enum PlayerStatusEnum {
    PLAYER_STATUS_OFFLINE(0),
    PLAYER_STATUS_UNKNOWN(1),
    PLAYER_STATUS_AVAILABLE(10),
    PLAYER_STATUS_IDLE(20),
    PLAYER_STATUS_AFK(21),
    PLAYER_STATUS_PRIVATE(30),
    PLAYER_STATUS_SOLO(40);
    
    private int value;
    PlayerStatusEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PlayerStatusEnum valueOf(int value) {
    	for (PlayerStatusEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
