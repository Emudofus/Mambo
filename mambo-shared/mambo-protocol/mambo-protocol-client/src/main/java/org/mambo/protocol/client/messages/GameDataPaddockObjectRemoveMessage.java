

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameDataPaddockObjectRemoveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5993;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cellId;
    
    public GameDataPaddockObjectRemoveMessage() { }
    
    public GameDataPaddockObjectRemoveMessage(short cellId) {
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
