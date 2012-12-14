

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum SubareaUpdateEventEnum {
    SUBAREA_EVENT_UNKNOWN(0),
    SUBAREA_EVENT_PRISM_ADDED(1),
    SUBAREA_EVENT_PRISM_REMOVED(2);
    
    private int value;
    SubareaUpdateEventEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static SubareaUpdateEventEnum valueOf(int value) {
    	for (SubareaUpdateEventEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
