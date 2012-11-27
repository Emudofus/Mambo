

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class DungeonPartyFinderRegisterRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6249;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] dungeonIds;
    
    public DungeonPartyFinderRegisterRequestMessage() { }
    
    public DungeonPartyFinderRegisterRequestMessage(short[] dungeonIds) {
        this.dungeonIds = dungeonIds;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(dungeonIds.length);
        for (short entry : dungeonIds) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        dungeonIds = new short[limit];
        for (int i = 0; i < limit; i++) {
            dungeonIds[i] = reader.readShort();
        }
    }
    
}
