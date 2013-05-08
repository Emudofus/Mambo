

// Generated on 05/08/2013 19:37:46
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AccountHouseMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6315;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public AccountHouseInformations[] houses;
    
    public AccountHouseMessage() { }
    
    public AccountHouseMessage(AccountHouseInformations[] houses) {
        this.houses = houses;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(houses.length);
        for (AccountHouseInformations entry : houses) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        houses = new AccountHouseInformations[limit];
        for (int i = 0; i < limit; i++) {
            houses[i] = new AccountHouseInformations();
            houses[i].deserialize(buf);
        }
    }
    
}
