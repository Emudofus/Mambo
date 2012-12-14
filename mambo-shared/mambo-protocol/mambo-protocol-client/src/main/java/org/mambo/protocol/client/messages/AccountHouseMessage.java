

// Generated on 12/14/2012 18:44:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(houses.length);
        for (AccountHouseInformations entry : houses) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        houses = new AccountHouseInformations[limit];
        for (int i = 0; i < limit; i++) {
            houses[i] = new AccountHouseInformations();
            houses[i].deserialize(reader);
        }
    }
    
}
