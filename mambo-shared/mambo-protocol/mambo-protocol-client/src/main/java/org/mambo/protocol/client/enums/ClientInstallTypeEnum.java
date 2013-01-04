

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum ClientInstallTypeEnum {
    CLIENT_INSTALL_UNKNOWN(0),
    CLIENT_BUNDLE(1),
    CLIENT_STREAMING(2);
    
    private int value;
    ClientInstallTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ClientInstallTypeEnum valueOf(int value) {
    	for (ClientInstallTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
