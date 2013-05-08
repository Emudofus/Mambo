

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AchievementFinishedInformationMessage extends AchievementFinishedMessage {
    public static final int MESSAGE_ID = 6381;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String name;
    public int playerId;
    
    public AchievementFinishedInformationMessage() { }
    
    public AchievementFinishedInformationMessage(short id, short finishedlevel, String name, int playerId) {
        super(id, finishedlevel);
        this.name = name;
        this.playerId = playerId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(name);
        buf.writeInt(playerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        name = buf.readString();
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
