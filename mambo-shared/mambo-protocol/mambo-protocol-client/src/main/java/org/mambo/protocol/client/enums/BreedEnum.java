

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum BreedEnum {
    UNDEFINED(0),
    Feca(1),
    Osamodas(2),
    Enutrof(3),
    Sram(4),
    Xelor(5),
    Ecaflip(6),
    Eniripsa(7),
    Iop(8),
    Cra(9),
    Sadida(10),
    Sacrieur(11),
    Pandawa(12),
    Roublard(13),
    Zobal(14),
    XV(15),
    SUMMONED(-1),
    MONSTER(-2),
    MONSTER_GROUP(-3),
    NPC(-4),
    HUMAN_VENDOR(-5),
    TAX_COLLECTOR(-6),
    MUTANT(-7),
    MUTANT_IN_DUNGEON(-8),
    MOUNT_OUTSIDE(-9),
    PRISM(-10),
    INCARNATION(-11);
    
    private int value;
    BreedEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static BreedEnum valueOf(int value) {
    	for (BreedEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
