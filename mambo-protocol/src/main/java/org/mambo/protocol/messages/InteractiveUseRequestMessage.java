

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class InteractiveUseRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5001;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int elemId;
    public int skillInstanceUid;
    
    public InteractiveUseRequestMessage() { }
    
    public InteractiveUseRequestMessage(int elemId, int skillInstanceUid) {
        this.elemId = elemId;
        this.skillInstanceUid = skillInstanceUid;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(elemId);
        buf.writeInt(skillInstanceUid);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        elemId = buf.readInt();
        if (elemId < 0)
            throw new RuntimeException("Forbidden value on elemId = " + elemId + ", it doesn't respect the following condition : elemId < 0");
        skillInstanceUid = buf.readInt();
        if (skillInstanceUid < 0)
            throw new RuntimeException("Forbidden value on skillInstanceUid = " + skillInstanceUid + ", it doesn't respect the following condition : skillInstanceUid < 0");
    }
    
}
