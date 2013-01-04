

// Generated on 01/04/2013 14:54:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class AbstractGameActionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1000;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short actionId;
    public int sourceId;
    
    public AbstractGameActionMessage() { }
    
    public AbstractGameActionMessage(short actionId, int sourceId) {
        this.actionId = actionId;
        this.sourceId = sourceId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(actionId);
        writer.writeInt(sourceId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        actionId = reader.readShort();
        if (actionId < 0)
            throw new RuntimeException("Forbidden value on actionId = " + actionId + ", it doesn't respect the following condition : actionId < 0");
        sourceId = reader.readInt();
    }
    
}
