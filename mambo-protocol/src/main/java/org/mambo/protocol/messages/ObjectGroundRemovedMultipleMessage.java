

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(cells.length);
        for (short entry : cells) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        cells = new short[limit];
        for (int i = 0; i < limit; i++) {
            cells[i] = buf.readShort();
        }
    }
    
}
