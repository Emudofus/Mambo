

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum ClientTechnologyEnum {
    CLIENT_TECHNOLOGY_UNKNOWN(0),
    CLIENT_AIR(1),
    CLIENT_FLASH(2);
    
    private int value;
    ClientTechnologyEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ClientTechnologyEnum valueOf(int value) {
    	for (ClientTechnologyEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
