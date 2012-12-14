

// Generated on 12/14/2012 18:44:13
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ExchangeObjectTransfertListFromInvMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6183;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] ids;
    
    public ExchangeObjectTransfertListFromInvMessage() { }
    
    public ExchangeObjectTransfertListFromInvMessage(int[] ids) {
        this.ids = ids;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(ids.length);
        for (int entry : ids) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        ids = new int[limit];
        for (int i = 0; i < limit; i++) {
            ids[i] = reader.readInt();
        }
    }
    
}
