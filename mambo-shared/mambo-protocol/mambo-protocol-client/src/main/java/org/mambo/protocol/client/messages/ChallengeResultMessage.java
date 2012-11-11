

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ChallengeResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6019;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte challengeId;
    public boolean success;
    
    public ChallengeResultMessage() { }
    
    public ChallengeResultMessage(byte challengeId, boolean success) {
        this.challengeId = challengeId;
        this.success = success;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(challengeId);
        writer.writeBoolean(success);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        challengeId = reader.readByte();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
        success = reader.readBoolean();
    }
    
}
