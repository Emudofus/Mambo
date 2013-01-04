

// Generated on 01/04/2013 14:54:19
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightSlideMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5525;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short startCellId;
    public short endCellId;
    
    public GameActionFightSlideMessage() { }
    
    public GameActionFightSlideMessage(short actionId, int sourceId, int targetId, short startCellId, short endCellId) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.startCellId = startCellId;
        this.endCellId = endCellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeShort(startCellId);
        writer.writeShort(endCellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        startCellId = reader.readShort();
        if (startCellId < -1 || startCellId > 559)
            throw new RuntimeException("Forbidden value on startCellId = " + startCellId + ", it doesn't respect the following condition : startCellId < -1 || startCellId > 559");
        endCellId = reader.readShort();
        if (endCellId < -1 || endCellId > 559)
            throw new RuntimeException("Forbidden value on endCellId = " + endCellId + ", it doesn't respect the following condition : endCellId < -1 || endCellId > 559");
    }
    
}
