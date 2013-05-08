

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(challengeId);
        buf.writeBoolean(success);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        challengeId = buf.readShort();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
        success = buf.readBoolean();
    }
    
}
