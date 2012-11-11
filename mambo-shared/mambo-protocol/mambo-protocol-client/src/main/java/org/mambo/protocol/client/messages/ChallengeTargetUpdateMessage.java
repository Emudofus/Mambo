

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
