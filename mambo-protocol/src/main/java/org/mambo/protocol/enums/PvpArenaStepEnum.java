

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

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
