

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum GuildRightsBitEnum {
    GUILD_RIGHT_NONE(0),
    GUILD_RIGHT_BOSS(1),
    GUILD_RIGHT_MANAGE_GUILD_BOOSTS(2),
    GUILD_RIGHT_MANAGE_RIGHTS(4),
    GUILD_RIGHT_INVITE_NEW_MEMBERS(8),
    GUILD_RIGHT_BAN_MEMBERS(16),
    GUILD_RIGHT_MANAGE_XP_CONTRIBUTION(32),
    GUILD_RIGHT_MANAGE_RANKS(64),
    GUILD_RIGHT_HIRE_TAX_COLLECTOR(128),
    GUILD_RIGHT_MANAGE_MY_XP_CONTRIBUTION(256),
    GUILD_RIGHT_COLLECT(512),
    GUILD_RIGHT_USE_PADDOCKS(4096),
    GUILD_RIGHT_ORGANIZE_PADDOCKS(8192),
    GUILD_RIGHT_TAKE_OTHERS_MOUNTS_IN_PADDOCKS(16384),
    GUILD_RIGHT_DEFENSE_PRIORITY(32768),
    GUILD_RIGHT_COLLECT_MY_TAX_COLLECTOR(65536);
    
    private int value;
    GuildRightsBitEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GuildRightsBitEnum valueOf(int value) {
    	for (GuildRightsBitEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
