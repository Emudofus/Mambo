

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum PlayerLifeStatusEnum {
    STATUS_ALIVE_AND_KICKING(0),
    STATUS_TOMBSTONE(1),
    STATUS_PHANTOM(2);
    
    private int value;
    PlayerLifeStatusEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PlayerLifeStatusEnum valueOf(int value) {
    	for (PlayerLifeStatusEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
