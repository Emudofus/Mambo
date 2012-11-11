

// Generated on 11/11/2012 20:41:33
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameRolePlayTaxCollectorFightRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5954;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int taxCollectorId;
    
    public GameRolePlayTaxCollectorFightRequestMessage() { }
    
    public GameRolePlayTaxCollectorFightRequestMessage(int taxCollectorId) {
        this.taxCollectorId = taxCollectorId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(taxCollectorId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        taxCollectorId = reader.readInt();
    }
    
}
