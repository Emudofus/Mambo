

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum MountEquipedErrorEnum {
    UNSET(0),
    SET(1),
    RIDING(2);
    
    private int value;
    MountEquipedErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static MountEquipedErrorEnum valueOf(int value) {
    	for (MountEquipedErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
