

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum GameContextEnum {
    ROLE_PLAY(1),
    FIGHT(2);
    
    private int value;
    GameContextEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static GameContextEnum valueOf(int value) {
    	for (GameContextEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
