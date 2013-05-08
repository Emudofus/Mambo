

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeShort(challengeId);
        buf.writeInt(targetId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        challengeId = buf.readShort();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
        targetId = buf.readInt();
    }
    
}
