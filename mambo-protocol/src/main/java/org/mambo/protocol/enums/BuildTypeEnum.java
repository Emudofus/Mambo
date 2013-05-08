

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum BuildTypeEnum {
    RELEASE(0),
    BETA(1),
    ALPHA(2),
    TESTING(3),
    INTERNAL(4),
    DEBUG(5),
    EXPERIMENTAL(6);
    
    private int value;
    BuildTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static BuildTypeEnum valueOf(int value) {
    	for (BuildTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
