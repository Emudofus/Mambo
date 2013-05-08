

// Generated on 05/08/2013 19:04:45
package org.mambo.protocol.enums;

public enum PresetSaveResultEnum {
    PRESET_SAVE_OK(1),
    PRESET_SAVE_ERR_UNKNOWN(2),
    PRESET_SAVE_ERR_TOO_MANY(3);
    
    private int value;
    PresetSaveResultEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PresetSaveResultEnum valueOf(int value) {
    	for (PresetSaveResultEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
