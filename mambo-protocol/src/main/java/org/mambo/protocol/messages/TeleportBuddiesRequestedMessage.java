

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(dungeonId);
        buf.writeInt(inviterId);
        buf.writeUShort(invalidBuddiesIds.length);
        for (int entry : invalidBuddiesIds) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        inviterId = buf.readInt();
        if (inviterId < 0)
            throw new RuntimeException("Forbidden value on inviterId = " + inviterId + ", it doesn't respect the following condition : inviterId < 0");
        int limit = buf.readUShort();
        invalidBuddiesIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            invalidBuddiesIds[i] = buf.readInt();
        }
    }
    
}
