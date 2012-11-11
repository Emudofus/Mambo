

// Generated on 11/11/2012 20:41:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameActionFightUnmarkCellsMessage extends AbstractGameActionMessage {
    public static final int MESSAGE_ID = 5570;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short markId;
    
    public GameActionFightUnmarkCellsMessage() { }
    
    public GameActionFightUnmarkCellsMessage(short actionId, int sourceId, short markId) {
        super(actionId, sourceId);
        this.markId = markId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(markId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        markId = reader.readShort();
    }
    
}
