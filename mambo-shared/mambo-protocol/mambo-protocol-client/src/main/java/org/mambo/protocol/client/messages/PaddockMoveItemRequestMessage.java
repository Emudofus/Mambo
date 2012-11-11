

// Generated on 11/11/2012 19:17:02
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class PaddockMoveItemRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6052;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short oldCellId;
    public short newCellId;
    
    public PaddockMoveItemRequestMessage() { }
    
    public PaddockMoveItemRequestMessage(short oldCellId, short newCellId) {
        this.oldCellId = oldCellId;
        this.newCellId = newCellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(oldCellId);
        writer.writeShort(newCellId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        oldCellId = reader.readShort();
        if (oldCellId < 0 || oldCellId > 559)
            throw new RuntimeException("Forbidden value on oldCellId = " + oldCellId + ", it doesn't respect the following condition : oldCellId < 0 || oldCellId > 559");
        newCellId = reader.readShort();
        if (newCellId < 0 || newCellId > 559)
            throw new RuntimeException("Forbidden value on newCellId = " + newCellId + ", it doesn't respect the following condition : newCellId < 0 || newCellId > 559");
    }
    
}
