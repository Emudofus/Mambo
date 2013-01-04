

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(name);
        writer.writeInt(playerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        name = reader.readString();
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
