

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum ChatErrorEnum {
    CHAT_ERROR_UNKNOWN(0),
    CHAT_ERROR_RECEIVER_NOT_FOUND(1),
    CHAT_ERROR_INTERIOR_MONOLOGUE(2),
    CHAT_ERROR_NO_GUILD(3),
    CHAT_ERROR_NO_PARTY(4),
    CHAT_ERROR_ALIGN(5),
    CHAT_ERROR_INVALID_MAP(6),
    CHAT_ERROR_NO_PARTY_ARENA(7),
    CHAT_ERROR_NO_TEAM(8);
    
    private int value;
    ChatErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ChatErrorEnum valueOf(int value) {
    	for (ChatErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
