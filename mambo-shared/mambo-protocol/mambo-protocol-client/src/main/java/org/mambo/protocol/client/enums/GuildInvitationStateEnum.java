

// Generated on 11/11/2012 20:41:43
package org.mambo.protocol.client.enums;

public enum GuildInvitationStateEnum {
    GUILD_INVITATION_SENT(1),
    GUILD_INVITATION_CANCELED(2),
    GUILD_INVITATION_OK(3);
    
    private int value;
    GuildInvitationStateEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GuildInvitationStateEnum valueOf(int value) {
    	for (GuildInvitationStateEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
