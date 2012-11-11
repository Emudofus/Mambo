

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeObjectTransfertListToInvMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6039;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] ids;
    
    public ExchangeObjectTransfertListToInvMessage() { }
    
    public ExchangeObjectTransfertListToInvMessage(int[] ids) {
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
