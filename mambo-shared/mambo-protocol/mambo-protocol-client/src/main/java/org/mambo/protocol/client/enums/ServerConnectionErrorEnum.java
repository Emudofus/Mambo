

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum ServerConnectionErrorEnum {
    SERVER_CONNECTION_ERROR_DUE_TO_STATUS(0),
    SERVER_CONNECTION_ERROR_NO_REASON(1),
    SERVER_CONNECTION_ERROR_ACCOUNT_RESTRICTED(2),
    SERVER_CONNECTION_ERROR_COMMUNITY_RESTRICTED(3),
    SERVER_CONNECTION_ERROR_LOCATION_RESTRICTED(4),
    SERVER_CONNECTION_ERROR_SUBSCRIBERS_ONLY(5),
    SERVER_CONNECTION_ERROR_REGULAR_PLAYERS_ONLY(6);
    
    private int value;
    ServerConnectionErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ServerConnectionErrorEnum valueOf(int value) {
    	for (ServerConnectionErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
