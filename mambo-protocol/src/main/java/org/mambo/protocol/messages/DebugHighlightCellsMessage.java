

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(color);
        buf.writeUShort(cells.length);
        for (short entry : cells) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        color = buf.readInt();
        int limit = buf.readUShort();
        cells = new short[limit];
        for (int i = 0; i < limit; i++) {
            cells[i] = buf.readShort();
        }
    }
    
}
