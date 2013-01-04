

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum TeamEnum {
    TEAM_CHALLENGER(0),
    TEAM_DEFENDER(1),
    TEAM_SPECTATOR(2);
    
    private int value;
    TeamEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static TeamEnum valueOf(int value) {
    	for (TeamEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
