

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeShort(oldCellId);
        buf.writeShort(newCellId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        oldCellId = buf.readShort();
        if (oldCellId < 0 || oldCellId > 559)
            throw new RuntimeException("Forbidden value on oldCellId = " + oldCellId + ", it doesn't respect the following condition : oldCellId < 0 || oldCellId > 559");
        newCellId = buf.readShort();
        if (newCellId < 0 || newCellId > 559)
            throw new RuntimeException("Forbidden value on newCellId = " + newCellId + ", it doesn't respect the following condition : newCellId < 0 || newCellId > 559");
    }
    
}
