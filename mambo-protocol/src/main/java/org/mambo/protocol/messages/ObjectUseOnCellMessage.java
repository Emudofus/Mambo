

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectUseOnCellMessage extends ObjectUseMessage {
    public static final int MESSAGE_ID = 3013;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cells;
    
    public ObjectUseOnCellMessage() { }
    
    public ObjectUseOnCellMessage(int objectUID, short cells) {
        super(objectUID);
        this.cells = cells;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeShort(cells);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        cells = buf.readShort();
        if (cells < 0 || cells > 559)
            throw new RuntimeException("Forbidden value on cells = " + cells + ", it doesn't respect the following condition : cells < 0 || cells > 559");
    }
    
}
