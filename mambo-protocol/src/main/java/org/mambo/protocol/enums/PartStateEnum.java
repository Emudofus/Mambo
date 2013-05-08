

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum PartStateEnum {
    PART_NOT_INSTALLED(0),
    PART_BEING_UPDATER(1),
    PART_UP_TO_DATE(2);
    
    private int value;
    PartStateEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PartStateEnum valueOf(int value) {
    	for (PartStateEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
