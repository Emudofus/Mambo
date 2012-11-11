

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum DebugLevelEnum {
    LEVEL_TRACE(0),
    LEVEL_DEBUG(1),
    LEVEL_INFO(2),
    LEVEL_WARN(3),
    LEVEL_ERROR(4),
    LEVEL_FATAL(5);
    
    private int value;
    DebugLevelEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static DebugLevelEnum valueOf(int value) {
    	for (DebugLevelEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
