

// Generated on 11/11/2012 18:18:42
package org.mambo.protocol.client.enums;

public enum ExchangeTypeEnum {
    NPC_SHOP(0),
    PLAYER_TRADE(1),
    NPC_TRADE(2),
    CRAFT(3),
    DISCONNECTED_VENDOR(4),
    STORAGE(5),
    SHOP_STOCK(6),
    TAXCOLLECTOR(8),
    NPC_MODIFY_TRADE(9),
    BIDHOUSE_SELL(10),
    BIDHOUSE_BUY(11),
    MULTICRAFT_CRAFTER(12),
    MULTICRAFT_CUSTOMER(13),
    JOB_INDEX(14),
    MOUNT(15),
    MOUNT_STABLE(16),
    NPC_RESURECT_PET(17),
    NPC_TRADE_MOUNT(18),
    REALESTATE_HOUSE(19),
    REALESTATE_FARM(20);
    
    private int value;
    ExchangeTypeEnum(int value) { this.value = value; }
    public int value() { return value; }
    
    public static ExchangeTypeEnum valueOf(int value) {
    	for (ExchangeTypeEnum a : values()) {
    		if (a.value == value)
    			return a;
    	}
    	return null;
    }
    
}
