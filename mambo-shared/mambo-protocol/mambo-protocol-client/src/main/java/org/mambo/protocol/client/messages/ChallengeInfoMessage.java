

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ChallengeInfoMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6022;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte challengeId;
    public int targetId;
    public int baseXpBonus;
    public int extraXpBonus;
    public int baseDropBonus;
    public int extraDropBonus;
    
    public ChallengeInfoMessage() { }
    
    public ChallengeInfoMessage(byte challengeId, int targetId, int baseXpBonus, int extraXpBonus, int baseDropBonus, int extraDropBonus) {
        this.challengeId = challengeId;
        this.targetId = targetId;
        this.baseXpBonus = baseXpBonus;
        this.extraXpBonus = extraXpBonus;
        this.baseDropBonus = baseDropBonus;
        this.extraDropBonus = extraDropBonus;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(challengeId);
        writer.writeInt(targetId);
        writer.writeInt(baseXpBonus);
        writer.writeInt(extraXpBonus);
        writer.writeInt(baseDropBonus);
        writer.writeInt(extraDropBonus);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        challengeId = reader.readByte();
        if (challengeId < 0)
            throw new RuntimeException("Forbidden value on challengeId = " + challengeId + ", it doesn't respect the following condition : challengeId < 0");
        targetId = reader.readInt();
        baseXpBonus = reader.readInt();
        if (baseXpBonus < 0)
            throw new RuntimeException("Forbidden value on baseXpBonus = " + baseXpBonus + ", it doesn't respect the following condition : baseXpBonus < 0");
        extraXpBonus = reader.readInt();
        if (extraXpBonus < 0)
            throw new RuntimeException("Forbidden value on extraXpBonus = " + extraXpBonus + ", it doesn't respect the following condition : extraXpBonus < 0");
        baseDropBonus = reader.readInt();
        if (baseDropBonus < 0)
            throw new RuntimeException("Forbidden value on baseDropBonus = " + baseDropBonus + ", it doesn't respect the following condition : baseDropBonus < 0");
        extraDropBonus = reader.readInt();
        if (extraDropBonus < 0)
            throw new RuntimeException("Forbidden value on extraDropBonus = " + extraDropBonus + ", it doesn't respect the following condition : extraDropBonus < 0");
    }
    
}
