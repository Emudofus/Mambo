

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

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
