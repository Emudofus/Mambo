

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CinematicMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6053;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short cinematicId;
    
    public CinematicMessage() { }
    
    public CinematicMessage(short cinematicId) {
        this.cinematicId = cinematicId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(cinematicId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        cinematicId = buf.readShort();
        if (cinematicId < 0)
            throw new RuntimeException("Forbidden value on cinematicId = " + cinematicId + ", it doesn't respect the following condition : cinematicId < 0");
    }
    
}
