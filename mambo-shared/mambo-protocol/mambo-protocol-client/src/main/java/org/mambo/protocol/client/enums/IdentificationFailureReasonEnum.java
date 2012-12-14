

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum IdentificationFailureReasonEnum {
    BAD_VERSION(1),
    WRONG_CREDENTIALS(2),
    BANNED(3),
    KICKED(4),
    IN_MAINTENANCE(5),
    TOO_MANY_ON_IP(6),
    TIME_OUT(7),
    BAD_IPRANGE(8),
    CREDENTIALS_RESET(9),
    EMAIL_UNVALIDATED(10),
    SERVICE_UNAVAILABLE(53),
    UNKNOWN_AUTH_ERROR(99),
    SPARE(100);
    
    private int value;
    IdentificationFailureReasonEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static IdentificationFailureReasonEnum valueOf(int value) {
    	for (IdentificationFailureReasonEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
