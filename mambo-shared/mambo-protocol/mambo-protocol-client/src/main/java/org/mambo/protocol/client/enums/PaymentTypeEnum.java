

// Generated on 11/11/2012 20:41:44
package org.mambo.protocol.client.enums;

public enum PaymentTypeEnum {
    PAYMENT_ON_SUCCESS_ONLY(0),
    PAYMENT_IN_ANY_CASE(1);
    
    private int value;
    PaymentTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PaymentTypeEnum valueOf(int value) {
    	for (PaymentTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
