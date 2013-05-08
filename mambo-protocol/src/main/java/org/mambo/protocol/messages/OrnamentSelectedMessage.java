

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class OrnamentSelectedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6369;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short ornamentId;
    
    public OrnamentSelectedMessage() { }
    
    public OrnamentSelectedMessage(short ornamentId) {
        this.ornamentId = ornamentId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(ornamentId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        ornamentId = buf.readShort();
        if (ornamentId < 0)
            throw new RuntimeException("Forbidden value on ornamentId = " + ornamentId + ", it doesn't respect the following condition : ornamentId < 0");
    }
    
}
