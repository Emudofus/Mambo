

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum ObjectErrorEnum {
    INVENTORY_FULL(1),
    CANNOT_EQUIP_TWICE(2),
    NOT_TRADABLE(3),
    CANNOT_DROP(4),
    CANNOT_DROP_NO_PLACE(5),
    CANNOT_DESTROY(6),
    LEVEL_TOO_LOW(7),
    LIVING_OBJECT_REFUSED_FOOD(8),
    CANNOT_UNEQUIP(9),
    CANNOT_EQUIP_HERE(10),
    CRITERIONS(11);
    
    private int value;
    ObjectErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ObjectErrorEnum valueOf(int value) {
    	for (ObjectErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
