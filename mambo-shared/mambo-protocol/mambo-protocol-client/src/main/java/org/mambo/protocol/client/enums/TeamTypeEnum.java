

// Generated on 11/11/2012 20:41:44
package org.mambo.protocol.client.enums;

public enum TeamTypeEnum {
    TEAM_TYPE_PLAYER(0),
    TEAM_TYPE_MONSTER(1),
    TEAM_TYPE_MUTANT(2),
    TEAM_TYPE_TAXCOLLECTOR(3),
    TEAM_TYPE_BAD_PLAYER(4);
    
    private int value;
    TeamTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static TeamTypeEnum valueOf(int value) {
    	for (TeamTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
