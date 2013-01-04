

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum ConsoleMessageTypeEnum {
    CONSOLE_TEXT_MESSAGE(0),
    CONSOLE_INFO_MESSAGE(1),
    CONSOLE_ERR_MESSAGE(2);
    
    private int value;
    ConsoleMessageTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ConsoleMessageTypeEnum valueOf(int value) {
    	for (ConsoleMessageTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
