

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum CompassTypeEnum {
    COMPASS_TYPE_SIMPLE(0),
    COMPASS_TYPE_SPOUSE(1),
    COMPASS_TYPE_PARTY(2),
    COMPASS_TYPE_PVP_SEEK(3),
    COMPASS_TYPE_QUEST(4);
    
    private int value;
    CompassTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static CompassTypeEnum valueOf(int value) {
    	for (CompassTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
