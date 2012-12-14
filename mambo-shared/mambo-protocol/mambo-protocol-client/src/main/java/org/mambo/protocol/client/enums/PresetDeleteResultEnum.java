

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum PresetDeleteResultEnum {
    PRESET_DEL_OK(1),
    PRESET_DEL_ERR_UNKNOWN(2),
    PRESET_DEL_ERR_BAD_PRESET_ID(3);
    
    private int value;
    PresetDeleteResultEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PresetDeleteResultEnum valueOf(int value) {
    	for (PresetDeleteResultEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
