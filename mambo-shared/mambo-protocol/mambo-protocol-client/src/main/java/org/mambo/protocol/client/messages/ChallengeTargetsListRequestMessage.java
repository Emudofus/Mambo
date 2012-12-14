

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChallengeTargetsListRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5614;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short challengeId;
    
    public ChallengeTargetsListRequestMessage() { }
    
    public ChallengeTargetsListRequestMessage(short challengeId) {
        this.challengeId = challengeId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(challengeId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        challengeId = reader.readShort();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
    }
    
}
