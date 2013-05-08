

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

public enum TeleporterTypeEnum {
    TELEPORTER_ZAAP(0),
    TELEPORTER_SUBWAY(1),
    TELEPORTER_PRISM(2);
    
    private int value;
    TeleporterTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static TeleporterTypeEnum valueOf(int value) {
    	for (TeleporterTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
