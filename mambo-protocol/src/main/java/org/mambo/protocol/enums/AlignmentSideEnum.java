

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum AlignmentSideEnum {
    ALIGNMENT_UNKNOWN(-2),
    ALIGNMENT_WITHOUT(-1),
    ALIGNMENT_NEUTRAL(0),
    ALIGNMENT_ANGEL(1),
    ALIGNMENT_EVIL(2),
    ALIGNMENT_MERCENARY(3);
    
    private int value;
    AlignmentSideEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static AlignmentSideEnum valueOf(int value) {
    	for (AlignmentSideEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
