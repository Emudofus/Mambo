

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameFightTurnListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 713;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] ids;
    public int[] deadsIds;
    
    public GameFightTurnListMessage() { }
    
    public GameFightTurnListMessage(int[] ids, int[] deadsIds) {
        this.ids = ids;
        this.deadsIds = deadsIds;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(ids.length);
        for (int entry : ids) {
            writer.writeInt(entry);
        }
        writer.writeUnsignedShort(deadsIds.length);
        for (int entry : deadsIds) {
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
        limit = reader.readUnsignedShort();
        deadsIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            deadsIds[i] = reader.readInt();
        }
    }
    
}
