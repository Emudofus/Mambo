

// Generated on 12/14/2012 18:33:50
package org.mambo.protocol.client.enums;

public enum CharacterDeletionErrorEnum {
    DEL_ERR_NO_REASON(1),
    DEL_ERR_TOO_MANY_CHAR_DELETION(2),
    DEL_ERR_BAD_SECRET_ANSWER(3),
    DEL_ERR_RESTRICED_ZONE(4);
    
    private int value;
    CharacterDeletionErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static CharacterDeletionErrorEnum valueOf(int value) {
    	for (CharacterDeletionErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
