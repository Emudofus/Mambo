

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectGroundListAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5925;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] cells;
    public int[] referenceIds;
    
    public ObjectGroundListAddedMessage() { }
    
    public ObjectGroundListAddedMessage(short[] cells, int[] referenceIds) {
        this.cells = cells;
        this.referenceIds = referenceIds;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(cells.length);
        for (short entry : cells) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(referenceIds.length);
        for (int entry : referenceIds) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        cells = new short[limit];
        for (int i = 0; i < limit; i++) {
            cells[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        referenceIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            referenceIds[i] = reader.readInt();
        }
    }
    
}
