

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

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
