

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ObjectGroundRemovedMultipleMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5944;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] cells;
    
    public ObjectGroundRemovedMultipleMessage() { }
    
    public ObjectGroundRemovedMultipleMessage(short[] cells) {
        this.cells = cells;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(cells.length);
        for (short entry : cells) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        cells = new short[limit];
        for (int i = 0; i < limit; i++) {
            cells[i] = reader.readShort();
        }
    }
    
}
