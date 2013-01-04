

// Generated on 01/04/2013 14:54:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeOnHumanVendorRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5772;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int humanVendorId;
    public int humanVendorCell;
    
    public ExchangeOnHumanVendorRequestMessage() { }
    
    public ExchangeOnHumanVendorRequestMessage(int humanVendorId, int humanVendorCell) {
        this.humanVendorId = humanVendorId;
        this.humanVendorCell = humanVendorCell;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(humanVendorId);
        writer.writeInt(humanVendorCell);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        humanVendorId = reader.readInt();
        if (humanVendorId < 0)
            throw new RuntimeException("Forbidden value on humanVendorId = " + humanVendorId + ", it doesn't respect the following condition : humanVendorId < 0");
        humanVendorCell = reader.readInt();
        if (humanVendorCell < 0)
            throw new RuntimeException("Forbidden value on humanVendorCell = " + humanVendorCell + ", it doesn't respect the following condition : humanVendorCell < 0");
    }
    
}
