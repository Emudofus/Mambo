

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum ChatActivableChannelsEnum {
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
    CHANNEL_ARENA(13),
    PSEUDO_CHANNEL_PRIVATE(9),
    PSEUDO_CHANNEL_INFO(10),
    PSEUDO_CHANNEL_FIGHT_LOG(11);
    
    private int value;
    ChatActivableChannelsEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ChatActivableChannelsEnum valueOf(int value) {
    	for (ChatActivableChannelsEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
