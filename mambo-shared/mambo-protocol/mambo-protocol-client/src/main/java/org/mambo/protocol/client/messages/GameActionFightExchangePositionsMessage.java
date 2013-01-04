

// Generated on 01/04/2013 14:54:18
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameActionFightExchangePositionsMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5527;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int targetId;
    public short casterCellId;
    public short targetCellId;
    
    public GameActionFightExchangePositionsMessage() { }
    
    public GameActionFightExchangePositionsMessage(short actionId, int sourceId, int targetId, short casterCellId, short targetCellId) {
        super(actionId, sourceId);
        this.targetId = targetId;
        this.casterCellId = casterCellId;
        this.targetCellId = targetCellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(targetId);
        writer.writeShort(casterCellId);
        writer.writeShort(targetCellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        targetId = reader.readInt();
        casterCellId = reader.readShort();
        if (casterCellId < -1 || casterCellId > 559)
            throw new RuntimeException("Forbidden value on casterCellId = " + casterCellId + ", it doesn't respect the following condition : casterCellId < -1 || casterCellId > 559");
        targetCellId = reader.readShort();
        if (targetCellId < -1 || targetCellId > 559)
            throw new RuntimeException("Forbidden value on targetCellId = " + targetCellId + ", it doesn't respect the following condition : targetCellId < -1 || targetCellId > 559");
    }
    
}
