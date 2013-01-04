

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum HardcoreDeathStateEnum {
    DEATH_STATE_ALIVE(0),
    DEATH_STATE_DEAD(1),
    DEATH_STATE_WAITING_CONFIRMATION(2);
    
    private int value;
    HardcoreDeathStateEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static HardcoreDeathStateEnum valueOf(int value) {
    	for (HardcoreDeathStateEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
