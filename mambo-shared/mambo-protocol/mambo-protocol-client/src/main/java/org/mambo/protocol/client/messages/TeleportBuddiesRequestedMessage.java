

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TeleportBuddiesRequestedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6302;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public int inviterId;
    public int[] invalidBuddiesIds;
    
    public TeleportBuddiesRequestedMessage() { }
    
    public TeleportBuddiesRequestedMessage(short dungeonId, int inviterId, int[] invalidBuddiesIds) {
        this.dungeonId = dungeonId;
        this.inviterId = inviterId;
        this.invalidBuddiesIds = invalidBuddiesIds;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(dungeonId);
        writer.writeInt(inviterId);
        writer.writeUnsignedShort(invalidBuddiesIds.length);
        for (int entry : invalidBuddiesIds) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        inviterId = reader.readInt();
        if (inviterId < 0)
            throw new RuntimeException("Forbidden value on inviterId = " + inviterId + ", it doesn't respect the following condition : inviterId < 0");
        int limit = reader.readUnsignedShort();
        invalidBuddiesIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            invalidBuddiesIds[i] = reader.readInt();
        }
    }
    
}
