

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum ListAddFailureEnum {
    LIST_ADD_FAILURE_UNKNOWN(0),
    LIST_ADD_FAILURE_OVER_QUOTA(1),
    LIST_ADD_FAILURE_NOT_FOUND(2),
    LIST_ADD_FAILURE_EGOCENTRIC(3),
    LIST_ADD_FAILURE_IS_DOUBLE(4);
    
    private int value;
    ListAddFailureEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ListAddFailureEnum valueOf(int value) {
    	for (ListAddFailureEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
