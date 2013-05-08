

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum ExchangeErrorEnum {
    REQUEST_IMPOSSIBLE(1),
    REQUEST_CHARACTER_OCCUPIED(2),
    REQUEST_CHARACTER_JOB_NOT_EQUIPED(3),
    REQUEST_CHARACTER_TOOL_TOO_FAR(4),
    REQUEST_CHARACTER_OVERLOADED(5),
    REQUEST_CHARACTER_NOT_SUSCRIBER(6),
    REQUEST_CHARACTER_RESTRICTED(7),
    BUY_ERROR(8),
    SELL_ERROR(9),
    MOUNT_PADDOCK_ERROR(10),
    BID_SEARCH_ERROR(11);
    
    private int value;
    ExchangeErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ExchangeErrorEnum valueOf(int value) {
    	for (ExchangeErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
