

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum GameHierarchyEnum {
    PLAYER(0),
    MODERATOR(10),
    GAMEMASTER_PADAWAN(20),
    GAMEMASTER(30),
    ADMIN(40);
    
    private int value;
    GameHierarchyEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GameHierarchyEnum valueOf(int value) {
    	for (GameHierarchyEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
