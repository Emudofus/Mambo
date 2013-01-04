

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum GuildInformationsTypeEnum {
    INFO_GENERAL(1),
    INFO_MEMBERS(2),
    INFO_BOOSTS(3),
    INFO_PADDOCKS(4),
    INFO_HOUSES(5),
    INFO_TAX_COLLECTOR(6),
    INFO_TAX_COLLECTOR_LEAVE(7);
    
    private int value;
    GuildInformationsTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GuildInformationsTypeEnum valueOf(int value) {
    	for (GuildInformationsTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
