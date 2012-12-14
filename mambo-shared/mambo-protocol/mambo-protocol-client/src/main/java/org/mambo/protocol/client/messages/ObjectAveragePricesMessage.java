

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectAveragePricesMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6335;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] ids;
    public int[] avgPrices;
    
    public ObjectAveragePricesMessage() { }
    
    public ObjectAveragePricesMessage(short[] ids, int[] avgPrices) {
        this.ids = ids;
        this.avgPrices = avgPrices;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(ids.length);
        for (short entry : ids) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(avgPrices.length);
        for (int entry : avgPrices) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        ids = new short[limit];
        for (int i = 0; i < limit; i++) {
            ids[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        avgPrices = new int[limit];
        for (int i = 0; i < limit; i++) {
            avgPrices[i] = reader.readInt();
        }
    }
    
}
