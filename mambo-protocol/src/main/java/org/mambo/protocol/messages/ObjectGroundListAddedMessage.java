

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(cells.length);
        for (short entry : cells) {
            buf.writeShort(entry);
        }
        buf.writeUShort(referenceIds.length);
        for (int entry : referenceIds) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        cells = new short[limit];
        for (int i = 0; i < limit; i++) {
            cells[i] = buf.readShort();
        }
        limit = buf.readUShort();
        referenceIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            referenceIds[i] = buf.readInt();
        }
    }
    
}
