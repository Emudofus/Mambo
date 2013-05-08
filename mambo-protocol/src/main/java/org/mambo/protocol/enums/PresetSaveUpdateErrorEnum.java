

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

public enum PresetSaveUpdateErrorEnum {
    PRESET_UPDATE_ERR_UNKNOWN(1),
    PRESET_UPDATE_ERR_BAD_PRESET_ID(2),
    PRESET_UPDATE_ERR_BAD_POSITION(3),
    PRESET_UPDATE_ERR_BAD_OBJECT_ID(4);
    
    private int value;
    PresetSaveUpdateErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PresetSaveUpdateErrorEnum valueOf(int value) {
    	for (PresetSaveUpdateErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
