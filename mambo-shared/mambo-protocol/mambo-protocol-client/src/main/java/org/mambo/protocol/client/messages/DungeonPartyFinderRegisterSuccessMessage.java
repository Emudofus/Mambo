

// Generated on 11/11/2012 19:17:04
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class DungeonPartyFinderRegisterSuccessMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6241;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] dungeonIds;
    
    public DungeonPartyFinderRegisterSuccessMessage() { }
    
    public DungeonPartyFinderRegisterSuccessMessage(short[] dungeonIds) {
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
