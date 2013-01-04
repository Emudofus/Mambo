

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

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
