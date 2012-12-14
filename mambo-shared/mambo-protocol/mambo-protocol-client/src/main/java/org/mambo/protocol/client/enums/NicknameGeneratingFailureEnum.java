

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum NicknameGeneratingFailureEnum {
    NICKNAME_GENERATOR_RETRY_TOO_SHORT(1),
    NICKNAME_GENERATOR_UNAVAILABLE(2);
    
    private int value;
    NicknameGeneratingFailureEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static NicknameGeneratingFailureEnum valueOf(int value) {
    	for (NicknameGeneratingFailureEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
