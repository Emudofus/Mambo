

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum PartyTypeEnum {
    PARTY_TYPE_UNDEFINED(0),
    PARTY_TYPE_CLASSICAL(1),
    PARTY_TYPE_DUNGEON(2),
    PARTY_TYPE_ARENA(3);
    
    private int value;
    PartyTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PartyTypeEnum valueOf(int value) {
    	for (PartyTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
