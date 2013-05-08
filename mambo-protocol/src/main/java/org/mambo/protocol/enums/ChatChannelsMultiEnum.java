

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum ChatChannelsMultiEnum {
    CHANNEL_GLOBAL(0),
    CHANNEL_TEAM(1),
    CHANNEL_GUILD(2),
    CHANNEL_ALIGN(3),
    CHANNEL_PARTY(4),
    CHANNEL_SALES(5),
    CHANNEL_SEEK(6),
    CHANNEL_NOOB(7),
    CHANNEL_ADMIN(8),
    CHANNEL_ADS(12),
    CHANNEL_ARENA(13);
    
    private int value;
    ChatChannelsMultiEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ChatChannelsMultiEnum valueOf(int value) {
    	for (ChatChannelsMultiEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
