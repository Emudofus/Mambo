

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.enums;

public enum DialogTypeEnum {
    DIALOG_BOOK(0),
    DIALOG_DIALOG(1),
    DIALOG_LOCKABLE(2),
    DIALOG_PURCHASABLE(3),
    DIALOG_GUILD_INVITATION(4),
    DIALOG_GUILD_CREATE(5),
    DIALOG_GUILD_RENAME(6),
    DIALOG_MARRIAGE(7),
    DIALOG_DUNGEON_MEETING(8),
    DIALOG_SPELL_FORGET(9),
    DIALOG_TELEPORTER(10),
    DIALOG_EXCHANGE(11);
    
    private int value;
    DialogTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static DialogTypeEnum valueOf(int value) {
    	for (DialogTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
