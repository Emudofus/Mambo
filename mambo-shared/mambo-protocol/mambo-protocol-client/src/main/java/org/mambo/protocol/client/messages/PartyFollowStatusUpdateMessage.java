

// Generated on 11/11/2012 20:41:29
package org.mambo.protocol.client.messages;

import org.mambo.core.io.*;

public class PartyFollowStatusUpdateMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 5581;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean success;
    public int followedId;
    
    public PartyFollowStatusUpdateMessage() { }
    
    public PartyFollowStatusUpdateMessage(int partyId, boolean success, int followedId) {
        super(partyId);
        this.success = success;
        this.followedId = followedId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeBoolean(success);
        writer.writeInt(followedId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        success = reader.readBoolean();
        followedId = reader.readInt();
        if (followedId < 0)
            throw new RuntimeException("Forbidden value on followedId = " + followedId + ", it doesn't respect the following condition : followedId < 0");
    }
    
}
