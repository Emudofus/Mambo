

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ChallengeInfoMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6022;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short challengeId;
    public int targetId;
    public int xpBonus;
    public int dropBonus;
    
    public ChallengeInfoMessage() { }
    
    public ChallengeInfoMessage(short challengeId, int targetId, int xpBonus, int dropBonus) {
        this.challengeId = challengeId;
        this.targetId = targetId;
        this.xpBonus = xpBonus;
        this.dropBonus = dropBonus;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(challengeId);
        buf.writeInt(targetId);
        buf.writeInt(xpBonus);
        buf.writeInt(dropBonus);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        challengeId = buf.readShort();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
        targetId = buf.readInt();
        xpBonus = buf.readInt();
        if (xpBonus < 0)
            throw new RuntimeException("Forbidden value on xpBonus = " + xpBonus + ", it doesn't respect the following condition : xpBonus < 0");
        dropBonus = buf.readInt();
        if (dropBonus < 0)
            throw new RuntimeException("Forbidden value on dropBonus = " + dropBonus + ", it doesn't respect the following condition : dropBonus < 0");
    }
    
}
