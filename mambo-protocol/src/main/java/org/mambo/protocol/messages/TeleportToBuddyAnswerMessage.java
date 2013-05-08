

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TeleportToBuddyAnswerMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6293;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public int buddyId;
    public boolean accept;
    
    public TeleportToBuddyAnswerMessage() { }
    
    public TeleportToBuddyAnswerMessage(short dungeonId, int buddyId, boolean accept) {
        this.dungeonId = dungeonId;
        this.buddyId = buddyId;
        this.accept = accept;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(dungeonId);
        buf.writeInt(buddyId);
        buf.writeBoolean(accept);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        dungeonId = buf.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        buddyId = buf.readInt();
        if (buddyId < 0)
            throw new RuntimeException("Forbidden value on buddyId = " + buddyId + ", it doesn't respect the following condition : buddyId < 0");
        accept = buf.readBoolean();
    }
    
}
