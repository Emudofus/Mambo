

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum SocialContactCategoryEnum {
    SOCIAL_CONTACT_FRIEND(0),
    SOCIAL_CONTACT_SPOUSE(1),
    SOCIAL_CONTACT_PARTY(2),
    SOCIAL_CONTACT_GUILD(3),
    SOCIAL_CONTACT_CRAFTER(4),
    SOCIAL_CONTACT_INTERLOCUTOR(5);
    
    private int value;
    SocialContactCategoryEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static SocialContactCategoryEnum valueOf(int value) {
    	for (SocialContactCategoryEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
