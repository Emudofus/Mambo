

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChallengeTargetUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6123;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte challengeId;
    public int targetId;
    
    public ChallengeTargetUpdateMessage() { }
    
    public ChallengeTargetUpdateMessage(byte challengeId, int targetId) {
        this.challengeId = challengeId;
        this.targetId = targetId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(challengeId);
        writer.writeInt(targetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        challengeId = reader.readByte();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
        targetId = reader.readInt();
    }
    
}
