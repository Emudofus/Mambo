

// Generated on 05/08/2013 19:04:44
package org.mambo.protocol.enums;

public enum PartyJoinErrorEnum {
    PARTY_JOIN_ERROR_UNKNOWN(0),
    PARTY_JOIN_ERROR_PLAYER_NOT_FOUND(1),
    PARTY_JOIN_ERROR_PARTY_NOT_FOUND(2),
    PARTY_JOIN_ERROR_PARTY_FULL(3),
    PARTY_JOIN_ERROR_PLAYER_BUSY(4),
    PARTY_JOIN_ERROR_PLAYER_ALREADY_INVITED(6),
    PARTY_JOIN_ERROR_PLAYER_TOO_SOLLICITED(7),
    PARTY_JOIN_ERROR_PLAYER_LOYAL(8),
    PARTY_JOIN_ERROR_UNMODIFIABLE(9),
    PARTY_JOIN_ERROR_UNMET_CRITERION(10);
    
    private int value;
    PartyJoinErrorEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static PartyJoinErrorEnum valueOf(int value) {
    	for (PartyJoinErrorEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
