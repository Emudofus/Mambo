

// Generated on 01/04/2013 14:54:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameRolePlayFightRequestCanceledMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5822;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int fightId;
    public int sourceId;
    public int targetId;
    
    public GameRolePlayFightRequestCanceledMessage() { }
    
    public GameRolePlayFightRequestCanceledMessage(int fightId, int sourceId, int targetId) {
        this.fightId = fightId;
        this.sourceId = sourceId;
        this.targetId = targetId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(fightId);
        writer.writeInt(sourceId);
        writer.writeInt(targetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightId = reader.readInt();
        sourceId = reader.readInt();
        if (sourceId < 0)
            throw new RuntimeException("Forbidden value on sourceId = " + sourceId + ", it doesn't respect the following condition : sourceId < 0");
        targetId = reader.readInt();
    }
    
}
