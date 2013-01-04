

// Generated on 01/04/2013 14:54:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChallengeTargetUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6123;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short challengeId;
    public int targetId;
    
    public ChallengeTargetUpdateMessage() { }
    
    public ChallengeTargetUpdateMessage(short challengeId, int targetId) {
        this.challengeId = challengeId;
        this.targetId = targetId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(challengeId);
        writer.writeInt(targetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        challengeId = reader.readShort();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
        targetId = reader.readInt();
    }
    
}
