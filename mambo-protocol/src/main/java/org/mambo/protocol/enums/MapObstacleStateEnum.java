

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum MapObstacleStateEnum {
    OBSTACLE_OPENED(1),
    OBSTACLE_CLOSED(2);
    
    private int value;
    MapObstacleStateEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static MapObstacleStateEnum valueOf(int value) {
    	for (MapObstacleStateEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
