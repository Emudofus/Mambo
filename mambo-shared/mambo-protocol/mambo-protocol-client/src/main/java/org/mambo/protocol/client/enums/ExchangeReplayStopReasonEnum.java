

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.enums;

public enum ExchangeReplayStopReasonEnum {
    STOPPED_REASON_OK(1),
    STOPPED_REASON_USER(2),
    STOPPED_REASON_MISSING_RESSOURCE(3),
    STOPPED_REASON_IMPOSSIBLE_CRAFT(4);
    
    private int value;
    ExchangeReplayStopReasonEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ExchangeReplayStopReasonEnum valueOf(int value) {
    	for (ExchangeReplayStopReasonEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
