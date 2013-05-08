

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

public enum ServerStatusEnum {
    STATUS_UNKNOWN(0),
    OFFLINE(1),
    STARTING(2),
    ONLINE(3),
    NOJOIN(4),
    SAVING(5),
    STOPING(6),
    FULL(7);
    
    private int value;
    ServerStatusEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ServerStatusEnum valueOf(int value) {
    	for (ServerStatusEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
