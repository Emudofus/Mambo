

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum PvpArenaStepEnum {
    ARENA_STEP_REGISTRED(0),
    ARENA_STEP_WAITING_FIGHT(1),
    ARENA_STEP_STARTING_FIGHT(2),
    ARENA_STEP_UNREGISTER(3);
    
    private int value;
    PvpArenaStepEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PvpArenaStepEnum valueOf(int value) {
    	for (PvpArenaStepEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
