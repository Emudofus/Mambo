

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class DebugHighlightCellsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 2001;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int color;
    public short[] cells;
    
    public DebugHighlightCellsMessage() { }
    
    public DebugHighlightCellsMessage(int color, short[] cells) {
        this.color = color;
        this.cells = cells;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(color);
        writer.writeUnsignedShort(cells.length);
        for (short entry : cells) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        color = reader.readInt();
        int limit = reader.readUnsignedShort();
        cells = new short[limit];
        for (int i = 0; i < limit; i++) {
            cells[i] = reader.readShort();
        }
    }
    
}
