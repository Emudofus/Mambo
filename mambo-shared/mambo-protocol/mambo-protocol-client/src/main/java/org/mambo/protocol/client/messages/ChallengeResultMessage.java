

// Generated on 01/04/2013 14:54:24
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ChallengeResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6019;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short challengeId;
    public boolean success;
    
    public ChallengeResultMessage() { }
    
    public ChallengeResultMessage(short challengeId, boolean success) {
        this.challengeId = challengeId;
        this.success = success;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(challengeId);
        writer.writeBoolean(success);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        challengeId = reader.readShort();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
        success = reader.readBoolean();
    }
    
}
