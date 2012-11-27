

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ShowCellMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5612;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int sourceId;
    public short cellId;
    
    public ShowCellMessage() { }
    
    public ShowCellMessage(int sourceId, short cellId) {
        this.sourceId = sourceId;
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(sourceId);
        writer.writeShort(cellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        sourceId = reader.readInt();
        cellId = reader.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
    }
    
}
