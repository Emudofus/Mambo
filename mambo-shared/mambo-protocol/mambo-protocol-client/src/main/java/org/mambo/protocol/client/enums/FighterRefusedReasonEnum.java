

// Generated on 01/04/2013 14:54:50
package org.mambo.protocol.client.enums;

public enum FighterRefusedReasonEnum {
    FIGHTER_ACCEPTED(0),
    CHALLENGE_FULL(1),
    TEAM_FULL(2),
    WRONG_ALIGNMENT(3),
    WRONG_GUILD(4),
    TOO_LATE(5),
    MUTANT_REFUSED(6),
    WRONG_MAP(7),
    JUST_RESPAWNED(8),
    IM_OCCUPIED(9),
    OPPONENT_OCCUPIED(10),
    FIGHT_MYSELF(11),
    INSUFFICIENT_RIGHTS(12),
    MEMBER_ACCOUNT_NEEDED(13),
    OPPONENT_NOT_MEMBER(14),
    TEAM_LIMITED_BY_MAINCHARACTER(15),
    MULTIACCOUNT_NOT_ALLOWED(16),
    GHOST_REFUSED(17),
    NEED_DISHONOR(18),
    RESTRICTED_ACCOUNT(19);
    
    private int value;
    FighterRefusedReasonEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static FighterRefusedReasonEnum valueOf(int value) {
    	for (FighterRefusedReasonEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
