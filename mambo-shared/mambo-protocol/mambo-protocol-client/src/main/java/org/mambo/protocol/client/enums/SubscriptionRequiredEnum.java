

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum SubscriptionRequiredEnum {
    LIMITED_TO_SUBSCRIBER(0),
    LIMIT_ON_JOB_XP(1),
    LIMIT_ON_JOB_USE(2),
    LIMIT_ON_MAP(3),
    LIMIT_ON_ITEM(4),
    LIMIT_ON_VENDOR(5);
    
    private int value;
    SubscriptionRequiredEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static SubscriptionRequiredEnum valueOf(int value) {
    	for (SubscriptionRequiredEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
