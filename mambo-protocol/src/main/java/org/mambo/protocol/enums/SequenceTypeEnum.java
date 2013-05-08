

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

public enum SequenceTypeEnum {
    SEQUENCE_SPELL(1),
    SEQUENCE_WEAPON(2),
    SEQUENCE_GLYPH_TRAP(3),
    SEQUENCE_TRIGGERED(4),
    SEQUENCE_MOVE(5),
    SEQUENCE_CHARACTER_DEATH(6),
    SEQUENCE_TURN_START(7),
    SEQUENCE_TURN_END(8),
    SEQUENCE_FIGHT_START(9);
    
    private int value;
    SequenceTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static SequenceTypeEnum valueOf(int value) {
    	for (SequenceTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
