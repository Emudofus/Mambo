

// Generated on 01/04/2013 14:54:23
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ShowCellRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5611;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cellId;
    
    public ShowCellRequestMessage() { }
    
    public ShowCellRequestMessage(short cellId) {
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(cellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        cellId = reader.readShort();
        if (cellId < 0 || cellId > 559)
            throw new RuntimeException("Forbidden value on cellId = " + cellId + ", it doesn't respect the following condition : cellId < 0 || cellId > 559");
    }
    
}
