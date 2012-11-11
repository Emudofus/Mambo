

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameActionFightThrowCharacterMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5829;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short cellId;
    
    public GameActionFightThrowCharacterMessage() { }
    
    public GameActionFightThrowCharacterMessage(short actionId, int sourceId, int targetId, short cellId) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeShort(cellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        cellId = reader.readShort();
        if (cellId < -1 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < -1 || cellId > 559");
    }
    
}
