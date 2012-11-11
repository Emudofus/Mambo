

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum FightOutcomeEnum {
    RESULT_LOST(0),
    RESULT_DRAW(1),
    RESULT_VICTORY(2),
    RESULT_TAX(5),
    RESULT_DEFENDER_GROUP(6);
    
    private int value;
    FightOutcomeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static FightOutcomeEnum valueOf(int value) {
    	for (FightOutcomeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
