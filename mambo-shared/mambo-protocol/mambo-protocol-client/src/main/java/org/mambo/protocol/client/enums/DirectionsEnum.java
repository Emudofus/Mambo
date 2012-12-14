

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum DirectionsEnum {
    DIRECTION_EAST(0),
    DIRECTION_SOUTH_EAST(1),
    DIRECTION_SOUTH(2),
    DIRECTION_SOUTH_WEST(3),
    DIRECTION_WEST(4),
    DIRECTION_NORTH_WEST(5),
    DIRECTION_NORTH(6),
    DIRECTION_NORTH_EAST(7);
    
    private int value;
    DirectionsEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static DirectionsEnum valueOf(int value) {
    	for (DirectionsEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
