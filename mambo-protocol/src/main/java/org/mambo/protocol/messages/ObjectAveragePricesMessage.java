

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(ids.length);
        for (short entry : ids) {
            buf.writeShort(entry);
        }
        buf.writeUShort(avgPrices.length);
        for (int entry : avgPrices) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        ids = new short[limit];
        for (int i = 0; i < limit; i++) {
            ids[i] = buf.readShort();
        }
        limit = buf.readUShort();
        avgPrices = new int[limit];
        for (int i = 0; i < limit; i++) {
            avgPrices[i] = buf.readInt();
        }
    }
    
}
