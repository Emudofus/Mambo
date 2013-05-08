

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectGroundRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 3014;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cell;
    
    public ObjectGroundRemovedMessage() { }
    
    public ObjectGroundRemovedMessage(short cell) {
        this.cell = cell;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(cell);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        cell = buf.readShort();
        if (cell < 0 || cell > 559)
            throw new RuntimeException("Forbidden value on cell = " + cell + ", it doesn't respect the following condition : cell < 0 || cell > 559");
    }
    
}
