

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

public enum ShortcutBarEnum {
    GENERAL_SHORTCUT_BAR(0),
    SPELL_SHORTCUT_BAR(1);
    
    private int value;
    ShortcutBarEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ShortcutBarEnum valueOf(int value) {
    	for (ShortcutBarEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
