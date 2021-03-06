

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum FightOptionsEnum {
    FIGHT_OPTION_SET_SECRET(0),
    FIGHT_OPTION_SET_TO_PARTY_ONLY(1),
    FIGHT_OPTION_SET_CLOSED(2),
    FIGHT_OPTION_ASK_FOR_HELP(3);
    
    private int value;
    FightOptionsEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static FightOptionsEnum valueOf(int value) {
    	for (FightOptionsEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
