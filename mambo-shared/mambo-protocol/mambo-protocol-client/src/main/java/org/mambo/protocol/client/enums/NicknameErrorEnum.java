

// Generated on 11/11/2012 20:41:43
package org.mambo.protocol.client.enums;

public enum NicknameErrorEnum {
    ALREADY_USED(1),
    SAME_AS_LOGIN(2),
    TOO_SIMILAR_TO_LOGIN(3),
    INVALID_NICK(4),
    UNKNOWN_NICK_ERROR(99);
    
    private int value;
    NicknameErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static NicknameErrorEnum valueOf(int value) {
    	for (NicknameErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
