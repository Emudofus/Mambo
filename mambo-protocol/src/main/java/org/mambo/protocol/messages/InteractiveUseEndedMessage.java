

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InteractiveUseEndedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6112;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int elemId;
    public short skillId;
    
    public InteractiveUseEndedMessage() { }
    
    public InteractiveUseEndedMessage(int elemId, short skillId) {
        this.elemId = elemId;
        this.skillId = skillId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(elemId);
        buf.writeShort(skillId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        elemId = buf.readInt();
        if (elemId < 0)
            throw new RuntimeException("Forbidden value on elemId = " + elemId + ", it doesn't respect the following condition : elemId < 0");
        skillId = buf.readShort();
        if (skillId < 0)
            throw new RuntimeException("Forbidden value on skillId = " + skillId + ", it doesn't respect the following condition : skillId < 0");
    }
    
}
