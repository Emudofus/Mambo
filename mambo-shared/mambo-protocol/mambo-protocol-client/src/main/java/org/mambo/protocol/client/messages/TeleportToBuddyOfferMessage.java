

// Generated on 11/11/2012 20:41:34
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class TeleportToBuddyOfferMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6287;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short dungeonId;
    public int buddyId;
    public int timeLeft;
    
    public TeleportToBuddyOfferMessage() { }
    
    public TeleportToBuddyOfferMessage(short dungeonId, int buddyId, int timeLeft) {
        this.dungeonId = dungeonId;
        this.buddyId = buddyId;
        this.timeLeft = timeLeft;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(dungeonId);
        writer.writeInt(buddyId);
        writer.writeInt(timeLeft);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        dungeonId = reader.readShort();
        if (dungeonId < 0)
            throw new RuntimeException("Forbidden value on dungeonId = " + dungeonId + ", it doesn't respect the following condition : dungeonId < 0");
        buddyId = reader.readInt();
        if (buddyId < 0)
            throw new RuntimeException("Forbidden value on buddyId = " + buddyId + ", it doesn't respect the following condition : buddyId < 0");
        timeLeft = reader.readInt();
        if (timeLeft < 0)
            throw new RuntimeException("Forbidden value on timeLeft = " + timeLeft + ", it doesn't respect the following condition : timeLeft < 0");
    }
    
}
