

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TeleportToBuddyCloseMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6303;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public int buddyId;
    
    public TeleportToBuddyCloseMessage() { }
    
    public TeleportToBuddyCloseMessage(short dungeonId, int buddyId) {
        this.dungeonId = dungeonId;
        this.buddyId = buddyId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(dungeonId);
        writer.writeInt(buddyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        buddyId = reader.readInt();
        if (buddyId < 0)
            throw new RuntimeException("Forbidden value on buddyId = " + buddyId + ", it doesn't respect the following condition : buddyId < 0");
    }
    
}
