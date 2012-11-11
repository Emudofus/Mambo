

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameActionFightInvisibleObstacleMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5820;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int sourceSpellId;
    
    public GameActionFightInvisibleObstacleMessage() { }
    
    public GameActionFightInvisibleObstacleMessage(short actionId, int sourceId, int sourceSpellId) {
        super(actionId, sourceId);
        this.sourceSpellId = sourceSpellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(sourceSpellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        sourceSpellId = reader.readInt();
        if (sourceSpellId < 0)
            throw new RuntimeException("Forbidden value on sourceSpellId = " + sourceSpellId + ", it doesn't respect the following condition : sourceSpellId < 0");
    }
    
}
