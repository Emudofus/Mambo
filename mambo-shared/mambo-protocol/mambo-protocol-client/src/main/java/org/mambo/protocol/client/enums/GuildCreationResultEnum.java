

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum GuildCreationResultEnum {
    GUILD_CREATE_OK(1),
    GUILD_CREATE_ERROR_NAME_INVALID(2),
    GUILD_CREATE_ERROR_ALREADY_IN_GUILD(3),
    GUILD_CREATE_ERROR_NAME_ALREADY_EXISTS(4),
    GUILD_CREATE_ERROR_EMBLEM_ALREADY_EXISTS(5),
    GUILD_CREATE_ERROR_LEAVE(6),
    GUILD_CREATE_ERROR_CANCEL(7),
    GUILD_CREATE_ERROR_REQUIREMENT_UNMET(8);
    
    private int value;
    GuildCreationResultEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GuildCreationResultEnum valueOf(int value) {
    	for (GuildCreationResultEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
