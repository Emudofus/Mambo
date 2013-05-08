

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum PlayableBreedEnum {
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
    Steamer(15);
    
    private int value;
    PlayableBreedEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PlayableBreedEnum valueOf(int value) {
    	for (PlayableBreedEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
